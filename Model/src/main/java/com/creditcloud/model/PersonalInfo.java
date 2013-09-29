/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model;

import com.creditcloud.model.enums.EthnicGroup;
import com.creditcloud.model.enums.user.info.MaritalStatus;
import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rooseek
 */
@XmlRootElement
public class PersonalInfo extends BaseObject {

    private static final long serialVersionUID = 20130918L;
    //性别

    @FormParam("male")
    @XmlElement(name = "male")
    private boolean male;

    @FormParam("ethnic")
    @XmlElement(name = "ethnic")
    private EthnicGroup ethnic;

    //出生日期
    @FormParam("dateOfBirth")
    @XmlElement(name = "dateOfBirth")
    private Date dateOfBirth;

    //婚姻状况
    @FormParam("maritalStatus")
    @XmlElement(name = "maritalStatus")
    private MaritalStatus maritalStatus;

    //有无子女
    @FormParam("children")
    @XmlElement(name = "children")
    private boolean children;

    //教育信息
    @FormParam("education")
    @XmlElement(name = "education")
    private EducationInfo education;

    //所在地信息
    @FormParam("place")
    @XmlElement(name = "place")
    private PlaceInfo place;

    //个人头像图片名
    @FormParam("avatar")
    @XmlElement(name = "avatar")
    private String avatar;

    /**
     *
     * @param male          性别
     * @param ethnic        民族
     * @param dateOfBirth   出生日期
     * @param maritalStatus 婚姻状况
     * @param children      有无子女
     * @param education     教育信息
     * @param place         籍贯及所在地信息
     * @param avatar        个人头像,可以为空
     */
    public PersonalInfo(boolean male,
                        EthnicGroup ethnic,
                        Date dateOfBirth,
                        MaritalStatus maritalStatus,
                        boolean children,
                        EducationInfo education,
                        PlaceInfo place,
                        String avatar) {
        this.male = male;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.children = children;
        this.education = education;
        this.place = place;
        this.avatar = avatar;
    }

    public PersonalInfo() {
    }

    public boolean isMale() {
        return male;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public boolean hasChildren() {
        return children;
    }

    public String getAvatar() {
        return avatar;
    }

    public EducationInfo getEducation() {
        return education;
    }

    public PlaceInfo getPlace() {
        return place;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public void setEducation(EducationInfo education) {
        this.education = education;
    }

    public void setPlace(PlaceInfo place) {
        this.place = place;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEthnic(EthnicGroup ethnic) {
        this.ethnic = ethnic;
    }

    public EthnicGroup getEthnic() {
        return ethnic;
    }

    public static PersonalInfo fromJsonString(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        JsonObject jo = Json.createReader(new StringReader(jsonString)).readObject();
        PersonalInfo result = new PersonalInfo();
        //头像是身份证照片
//        result.setAvatar(jo.getString("avatar"));
        result.setChildren(jo.getBoolean("children"));
        //出生日期应该是跟身份证对应的，所以不能更改
//        result.setDateOfBirth(new Date(jo.getInt("dateOfBirth")));
        result.setEducation(EducationInfo.fromJsonString(jo.getJsonObject("education").toString()));
        result.setMaritalStatus(MaritalStatus.valueOf(jo.getString("maritalStatus")));
        result.setPlace(PlaceInfo.fromJsonString(jo.getJsonObject("place").toString()));
        //性别从身份证中获得
//        result.setMale(jo.getBoolean("male"));

        return result;
    }
}
