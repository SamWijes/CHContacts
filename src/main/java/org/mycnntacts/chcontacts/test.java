package org.mycnntacts.chcontacts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class test {

	public static void main(String[] args) throws IOException {
		Path filePath = Paths.get("C:/Users/samit/Documents/CODE/JMC");


		try (Stream<Path> topLevelFolders = Files.list(filePath)) {
			topLevelFolders
					.filter(path -> Files.isDirectory(path))
					.forEach(folder -> {
						try (Stream<Path> subFolders = Files.list(folder)) {
							subFolders
									.filter(sub -> Files.isDirectory(sub))
									.filter(sub->sub.getFileName().toString().equals("src"))
									.map(sub -> folder.getFileName() + "/" + sub.getFileName())
									.forEach(System.out::println);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
