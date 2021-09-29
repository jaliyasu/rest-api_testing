package com.assurity.test.qa.model.catagory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * catagoty POJO class
 *
 * @author jaliya Sumanadasa
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Catagory {

    private String Name;

    private String Path;

    private boolean CanListAuctions;

    private boolean CanListClassifieds;

    private boolean CanRelist;

    private String LegalNotice;

    private int DefaultDuration;

    private int MaximumTitleLength;

    private int AreaOfBusiness;

    private int DefaultRelistDuration;

    private int FreePhotoCount;

    private int MaximumPhotoCount;

    private boolean IsFreeToRelist;


    private List<Promotions> Promotions;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public boolean isCanListAuctions() {
        return CanListAuctions;
    }

    public void setCanListAuctions(boolean canListAuctions) {
        CanListAuctions = canListAuctions;
    }

    public boolean isCanListClassifieds() {
        return CanListClassifieds;
    }

    public void setCanListClassifieds(boolean canListClassifieds) {
        CanListClassifieds = canListClassifieds;
    }

    public boolean isCanRelist() {
        return CanRelist;
    }

    public void setCanRelist(boolean canRelist) {
        CanRelist = canRelist;
    }

    public String getLegalNotice() {
        return LegalNotice;
    }

    public void setLegalNotice(String legalNotice) {
        LegalNotice = legalNotice;
    }

    public int getDefaultDuration() {
        return DefaultDuration;
    }

    public void setDefaultDuration(int defaultDuration) {
        DefaultDuration = defaultDuration;
    }

    public int getMaximumTitleLength() {
        return MaximumTitleLength;
    }

    public void setMaximumTitleLength(int maximumTitleLength) {
        MaximumTitleLength = maximumTitleLength;
    }

    public int getAreaOfBusiness() {
        return AreaOfBusiness;
    }

    public void setAreaOfBusiness(int areaOfBusiness) {
        AreaOfBusiness = areaOfBusiness;
    }

    public int getDefaultRelistDuration() {
        return DefaultRelistDuration;
    }

    public void setDefaultRelistDuration(int defaultRelistDuration) {
        DefaultRelistDuration = defaultRelistDuration;
    }

    public int getFreePhotoCount() {
        return FreePhotoCount;
    }

    public void setFreePhotoCount(int freePhotoCount) {
        FreePhotoCount = freePhotoCount;
    }

    public int getMaximumPhotoCount() {
        return MaximumPhotoCount;
    }

    public void setMaximumPhotoCount(int maximumPhotoCount) {
        MaximumPhotoCount = maximumPhotoCount;
    }

    public boolean isFreeToRelist() {
        return IsFreeToRelist;
    }

    public void setFreeToRelist(boolean freeToRelist) {
        IsFreeToRelist = freeToRelist;
    }

    public List<com.assurity.test.qa.model.catagory.Promotions> getPromotions() {
        return Promotions;
    }

    public void setPromotions(List<com.assurity.test.qa.model.catagory.Promotions> promotions) {
        Promotions = promotions;
    }
}
