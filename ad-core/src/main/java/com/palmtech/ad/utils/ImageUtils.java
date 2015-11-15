package com.palmtech.ad.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	/** 
	 *  图片文件读取
	 *     @param srcImgPath
	 *    @return 
	 * 
	 **/
	private static BufferedImage InputImage(String srcImgPath) {
		BufferedImage srcImage = null;
		try {
			FileInputStream in = new FileInputStream(srcImgPath);
			srcImage = javax.imageio.ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("读取图片文件出错！" + e.getMessage());
			e.printStackTrace();
		}
		return srcImage;
	}

	/**
	 *  强制转化到指定大小
	 *  @param srcImgPath :源图片路径 
	 *  @param outImgPath  :输出的压缩图片的路径 
	 *   @param new_w:压缩后的图片宽 
	 *   @param new_h  :压缩后的图片高
	 */
	public static void resizeByForce(String srcImgPath, String outImgPath,
			int new_w, int new_h) {
		BufferedImage src = InputImage(srcImgPath);
		disposeImage(src, outImgPath, new_w, new_h);
	}
	
	/**
	 *  等比压缩
	 *  @param srcImgPath :源图片路径 
	 *  @param outImgPath  :输出的压缩图片的路径 
	 *   @param max_w:压缩后的图片宽 
	 *   @param max_h  :压缩后的图片高
	 */
	public static void resizeByBalance(String srcImgPath, String outImgPath,
			int max_w, int max_h) {
		BufferedImage src = InputImage(srcImgPath);
		int src_w = src.getWidth(); 
		int src_h = src.getHeight();
		double scale = 0;
		double scaleW = (double)max_w/(double)src_w;
		double scaleH =  (double)max_h/(double)src_h;
		scale = scaleW <scaleH  ?scaleW:scaleH; //取小
		int balance_w = (int)(src_w*scale);
		int balance_h = (int)(src_h*scale);
		
		disposeImage(src, outImgPath, balance_w, balance_h);
	}


	

	/**
 	  * 处理图片 
 	  * @param src 
 	  * @param outImgPath 
 	  * @param new_w 
 	  * @param new_h
 	  *     
 	  */
	private synchronized static void disposeImage(BufferedImage src,
			String outImgPath, int new_w, int new_h) {
		
		// 得到源图长
		BufferedImage newImg = null;
		// 判断输入图片的类型
		newImg = new BufferedImage(new_w, new_h, src.getType());
			
		Graphics2D g = newImg.createGraphics();
		newImg =g.getDeviceConfiguration().createCompatibleImage(new_w, new_h,Transparency.TRANSLUCENT);
		g.dispose();
		g = newImg.createGraphics();


		// 根据图片尺寸压缩比得到新图的尺寸
		newImg.getGraphics().drawImage(
				src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0,
				null);
		// 调用方法输出图片文件
		OutImage(outImgPath, newImg);
	}

	/**
	 *  将图片文件输出到指定的路径，
	 *   @param outImgPath 
	 *    @param newImg 
	 */
	private static void OutImage(String outImgPath, BufferedImage newImg) {
		// 判断输出的文件夹路径是否存在，不存在则创建
		File file = new File(outImgPath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}// 输出到文件流
		try {
			ImageIO.write(newImg,
					outImgPath.substring(outImgPath.lastIndexOf(".") + 1),
					new File(outImgPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
