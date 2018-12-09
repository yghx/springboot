package love.yi.helloword.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;

public class Base64Image {
	public static String toBase64() {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream("./1.jpg");
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s = new String(Base64.encodeBase64(data));
		System.out.println(s);
		return s;
	}

	public static void toImage(String base64) {

		try {
			// Base64解码
			byte[] bytes = Base64.decodeBase64(base64);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream("./2.jpg");
//          ServletOutputStream out = response.getOutputStream();
			out.write(bytes);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		toImage(toBase64());
	}
}
