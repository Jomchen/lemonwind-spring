package com.lemonwind.spring.demo.config.scan.scanentity;

import lombok.Data;

/**
 * 用于被扫描到用于实例化
 */
@Data
public class ScannedEntityFirst {
    private String username = "scannedEntityFirst";
}
