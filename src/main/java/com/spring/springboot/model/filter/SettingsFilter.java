package com.spring.springboot.model.filter;

import com.spring.springboot.dal.SettingsDto;
import com.spring.springboot.model.ProductType;
import com.spring.springboot.model.Settings;
import lombok.Data;

@Data
public class SettingsFilter {
    public static Settings getSettings(ProductType productType, SettingsDto settingsDto){
        Settings settings = new Settings();
        switch (productType){
            case HARD_DISK : settings =  Settings.builder()
                    .additionalSettings(settingsDto.getMemoryCapacity())
                    .build(); break;
            case PERSONAL_PC :  settings =  Settings.builder()
                    .additionalSettings(settingsDto.getFormFactor())
                    .build(); break;
            case MONITOR :
            case LAPTOP :
                settings =  Settings.builder()
                    .additionalSettings(settingsDto.getDiagonal())
                    .build(); break;
        }
        return settings;
    }
}
