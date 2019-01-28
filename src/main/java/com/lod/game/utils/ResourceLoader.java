package com.lod.game.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceLoader {

    public static final String PATH = "/";

    public static BufferedImage loadImage(String filename) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(ResourceLoader.class.getResource(PATH + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static int[][] lvlParser(String filePath) {
        List<List<Integer>> lvlLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ResourceLoader.class.getResource(PATH + filePath).getFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lvlLines.add(strToIntArrays(line.split(" ")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lvlLines.stream()
                .map(integers -> integers.stream()
                        .mapToInt(i -> i)
                        .toArray())
                .toArray(int[][]::new);
    }

    public static List<Integer> strToIntArrays(String[] sArr) {
        return Arrays.stream(sArr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}
