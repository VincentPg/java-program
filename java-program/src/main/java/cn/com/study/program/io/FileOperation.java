package cn.com.study.program.io;

import java.io.File;
import java.io.IOException;

/**
 * (JDK6)
 * 文件操作：
 *     创建文件、目录、拷贝、遍历。
 * @author admin
 *
 */
public class FileOperation {
	public static void main(String[] args) {
		File file = createFile("F:/","test.txt");
		String type = getType(file);
		File fileDirectory = new File("F:/123456/");
		createDirectory(fileDirectory);
	}
	public static boolean createDirectory(File file){
		boolean flag = file.mkdirs();
		if(flag){
			System.out.println("成功创建目录");
		}else{
			System.out.println("创建目录失败");
		}
		return flag;
	}
	/**
	 * 在指定路径创建文件
	 * @param path
	 * @param fileName
	 * @return          返回创建后的文件。
	 */
	public static File createFile(String path,String fileName){
		File filePath = new File(path+fileName);
		//默认创建失败
		boolean flag =false;
		try {
			flag=filePath.createNewFile();
			if (flag){
				System.out.println("成功在"+path+"创建文件" + fileName);
			}else{
				System.out.println("创建文件失败!!");
			}
		} catch (IOException e) {
			System.out.println("创建文件异常!!!");
			e.printStackTrace();
			return null;
		}
		return filePath;
		
	}
	/**
	 * 获取传入File的属性：目录、标准文件、隐藏文件。
	 * 注：隐藏文件也是文件。
	 * @param file
	 * @return
	 */
	public static String getType(File file){
		if(file.isDirectory()){
			System.out.println("这是目录!!!");
			return "Directory";
		}else if (file.isFile()){
			System.out.println("这是文件!!!");
			return "File";
		}else if (file.isHidden()){
			System.out.println("这是隐藏文件!!!");
			return "HiddenFile";
		}else{
			System.out.println("这是其它");
			return "other";
		}
		
	}
}
