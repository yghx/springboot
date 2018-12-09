package love.yi.helloword.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//@RestController
@Controller
public class TransformFileController {

	@RequestMapping("/uploadFile")
	public @ResponseBody Object uploadFile(@RequestParam("fileUpload")MultipartFile multipartFile) throws IOException {
		String originalFilename = multipartFile.getOriginalFilename();//文件原始名称
		String name = multipartFile.getName();//文件的表单名称
		InputStream is = multipartFile.getInputStream();
		long l = System.currentTimeMillis();
		FileOutputStream os = new FileOutputStream(new File("./"+l + originalFilename));
		byte[] buff = new byte[1024];
		int i = 0;
		while((i = is.read(buff))!=-1) {
			os.write(buff,0,i);
		}
		os.flush();
		os.close();
		is.close();
		HashMap<String, String> hashMap = new HashMap<String,String>();
		String put = hashMap.put("1", "2");
		System.out.println(put);
		return hashMap;
	}
	
	@RequestMapping("/uploadFileM")
	public @ResponseBody Object uploadFile2(MultipartHttpServletRequest request) throws IOException {
		List<MultipartFile> list = request.getMultiFileMap().get("fileUpload");
		MultipartFile multipartFile = list.get(0);
		String originalFilename = multipartFile.getOriginalFilename();//文件原始名称
		String name = multipartFile.getName();//文件的表单名称
		InputStream is = multipartFile.getInputStream();
		long l = System.currentTimeMillis();
		FileOutputStream os = new FileOutputStream(new File("./"+l + originalFilename));
		byte[] buff = new byte[1024];
		int i = 0;
		while((i = is.read(buff))!=-1) {
			os.write(buff,0,i);
		}
		os.flush();
		os.close();
		is.close();
		HashMap<String, String> hashMap = new HashMap<String,String>();
		String put = hashMap.put("1", "2");
		System.out.println(put);
		return hashMap;
	}

	@RequestMapping("/uploadFileR")
	public @ResponseBody Object uploadFile2(HttpServletRequest request) throws IOException {
		if(!(ServletFileUpload.isMultipartContent(request))) {
			return null;
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
//		upload.setFileSizeMax(1024*1024);
//		upload.setFileItemFactory(factory);
		List<FileItem> list = upload.parseRequest(request);
		
		for (FileItem fileItem : list) {
			String originalFilename = fileItem.getFieldName();//文件原始名称
			String name = fileItem.getName();//文件的表单名称
			InputStream is = fileItem.getInputStream();
			long l = System.currentTimeMillis();
			FileOutputStream os = new FileOutputStream(new File("./"+l + originalFilename));
			byte[] buff = new byte[1024];
			int i = 0;
			while((i = is.read(buff))!=-1) {
				os.write(buff,0,i);
			}
			os.flush();
			os.close();
			is.close();
		}
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		String put = hashMap.put("1", "2");
		System.out.println(put);
		return hashMap;
	}
}
