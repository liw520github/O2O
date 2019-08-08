package com.myo2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtil {
	public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(400, 400).outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}

	public static String generateNormalImg(InputStream thumbnailInputStream, String fileName, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(337, 640).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}

//	public static List<String> generateNormalImgs(List<String> imgs, String targetAddr) {
//		int count = 0;
//		List<String> relativeAddrList = new ArrayList<String>();
//		if (imgs != null && imgs.size() > 0) {
//			makeDirPath(targetAddr);
//			for (String img : imgs) {
//				String realFileName = FileUtil.getRandomFileName();
//				String extension = getFileExtension(img);
//				String relativeAddr = targetAddr + realFileName + count + extension;
//				File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
//				count++;
//				try {
//					Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
//				} catch (IOException e) {
//					throw new RuntimeException("创建图片失败：" + e.toString());
//				}
//				relativeAddrList.add(relativeAddr);
//			}
//		}
//		return relativeAddrList;
//	}

	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	private static String getFileExtension(String fileName) {

		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * storePath是文件的路径还是目录的路径 
	 * 如果storePath是文件路径则删除该文件 
	 * 如果storePath是目录路径则删除该目录下的所有文件
	 * 
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(FileUtil.getImgBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
