package com.lz.mybatis.generator;


import com.lz.mybatis.generator.util.GeneratorConfigXml;
import com.lz.mybatis.generator.util.GeneratorMetadata;

/**
 * Created by john on 2016/4/8.
 */
public class GeneratorMain {
    public static void main(String[] args) {
        String generatorConfigPath = GeneratorConfigXml.generate();
        GeneratorMetadata.remove();
        GeneratorMetadata.generate(generatorConfigPath);
    }
}
