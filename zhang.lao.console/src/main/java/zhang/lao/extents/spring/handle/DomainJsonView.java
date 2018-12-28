package zhang.lao.extents.spring.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangqin on 2017/4/6.
 */
public class DomainJsonView extends AbstractView {

    private static final String contentType = "application/json; charset=UTF-8";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Charset charset;
    private SerializerFeature[] serializerFeatures;
    private Set<String> renderedAttributes;
    private boolean disableCaching;
    private boolean updateContentLength;
    private boolean extractValueFromSingleKeyModel;
    private String domain;

    public DomainJsonView() {
        this.charset=UTF8;
        this.serializerFeatures = new SerializerFeature[0];
        this.disableCaching = true;
        this.updateContentLength = false;
        this.extractValueFromSingleKeyModel = true;
        this.setContentType(contentType);
        this.setExposePathVariables(false);
    }
    public void setRenderedAttributes(Set<String> renderedAttributes) {
        this.renderedAttributes = renderedAttributes;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /** @deprecated */
    @Deprecated
    public void setSerializerFeature(SerializerFeature... features) {
        this.setFeatures(features);
    }


    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public SerializerFeature[] getFeatures() {
        return this.serializerFeatures;
    }

    public void setFeatures(SerializerFeature... features) {
        this.serializerFeatures = features;
    }

    public boolean isExtractValueFromSingleKeyModel() {
        return this.extractValueFromSingleKeyModel;
    }

    public void setExtractValueFromSingleKeyModel(boolean extractValueFromSingleKeyModel) {
        this.extractValueFromSingleKeyModel = extractValueFromSingleKeyModel;
    }

    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object value = this.filterModel(model);
        String text ="";
        if(org.apache.commons.lang3.StringUtils.isNotBlank(domain)){
            text = domain+"("+JSON.toJSONString(value, this.serializerFeatures)+")";
        }else{
            text = JSON.toJSONString(value, this.serializerFeatures);
        }

        byte[] bytes = text.getBytes(this.charset);
        Object stream = this.updateContentLength?this.createTemporaryOutputStream():response.getOutputStream();
        ((OutputStream)stream).write(bytes);
        if(this.updateContentLength) {
            this.writeToResponse(response, (ByteArrayOutputStream)stream);
        }

    }

    protected void prepareResponse(HttpServletRequest request, HttpServletResponse response) {
        this.setResponseContentType(request, response);
        response.setContentType(getContentType());
        if(this.disableCaching) {
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
            response.addDateHeader("Expires", 1L);
        }


    }

    public void setDisableCaching(boolean disableCaching) {
        this.disableCaching = disableCaching;
    }

    public void setUpdateContentLength(boolean updateContentLength) {
        this.updateContentLength = updateContentLength;
    }

    protected Object filterModel(Map<String, Object> model) {
        HashMap result = new HashMap(model.size());
        Set renderedAttributes = !CollectionUtils.isEmpty(this.renderedAttributes)?this.renderedAttributes:model.keySet();
        Iterator var4 = model.entrySet().iterator();

        Map.Entry entry;
        while(var4.hasNext()) {
            entry = (Map.Entry)var4.next();
            if(!(entry.getValue() instanceof BindingResult) && renderedAttributes.contains(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        if(this.extractValueFromSingleKeyModel && result.size() == 1) {
            var4 = result.entrySet().iterator();
            if(var4.hasNext()) {
                entry = (Map.Entry)var4.next();
                return entry.getValue();
            }
        }

        return result;
    }
}
