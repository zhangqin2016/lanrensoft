package zhang.lao.tool;

import java.util.UUID;

public class UUIDTool {

	public static synchronized String getUUID(){
			return UUID.randomUUID().toString().replace("-", "");
	}
}
