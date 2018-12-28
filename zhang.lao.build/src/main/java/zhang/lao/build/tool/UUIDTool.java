package zhang.lao.build.tool;

import java.util.UUID;

public class UUIDTool {

	public static synchronized String getUUID(){
			return UUID.randomUUID().toString().replace("-", "");
	}
}
