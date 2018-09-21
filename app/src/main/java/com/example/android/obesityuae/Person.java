package com.example.android.obesityuae;

import android.app.Application;

/**
 * Created by shaheen on 4/11/2018.
 */

public class Person extends Application {

    private int progress=0, waist=-1, gender=-1, martial=-1;
    private double height=-1, weight=-1;
    private int nationality=-1, residence=-1, residenceType=-1, income=-1, exercise=-1;
    private int workActivity=-1, education=-1, mobilePhones=-1, internet=-1, internetYears=-1;
    private int uSnore=-1, uInsomnia=-1, uHeadache=-1, uNarcolepsy=-1, uFertility=-1, uBackJoint=-1;
    private int uSkin=-1, uThyroid=-1, uHeart=-1, uHypertension=-1, uDiabetes=-1, uCancer=-1;
    private int fThyroid=-1, fHeart=-1, fHypertension=-1, fDiabetes=-1, fCancer=-1;
    private int day=-1, month=-1, year=-1;
    private String diet="", progressText="0%";

    public String getProgressText() {
        return progressText;
    }

    public void setProgressText(String progressText) {
        this.progressText = progressText;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getExercise() {
        return exercise;
    }

    public void setExercise(int exercise) {
        this.exercise = exercise;
    }

    public int getfCancer() {
        return fCancer;
    }

    public void setfCancer(int fCancer) {
        this.fCancer = fCancer;
    }

    public int getfDiabetes() {
        return fDiabetes;
    }

    public void setfDiabetes(int fDiabetes) {
        this.fDiabetes = fDiabetes;
    }

    public int getfHeart() {
        return fHeart;
    }

    public void setfHeart(int fHeart) {
        this.fHeart = fHeart;
    }

    public int getfHypertension() {
        return fHypertension;
    }

    public void setfHypertension(int fHypertension) {
        this.fHypertension = fHypertension;
    }

    public int getfThyroid() {
        return fThyroid;
    }

    public void setfThyroid(int fThyroid) {
        this.fThyroid = fThyroid;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getInternetYears() {
        return internetYears;
    }

    public void setInternetYears(int internetYears) {
        this.internetYears = internetYears;
    }

    public int getMartial() {
        return martial;
    }

    public void setMartial(int martial) {
        this.martial = martial;
    }

    public int getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(int mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getResidence() {
        return residence;
    }

    public void setResidence(int residence) {
        this.residence = residence;
    }

    public int getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(int residenceType) {
        this.residenceType = residenceType;
    }

    public int getuBackJoint() {
        return uBackJoint;
    }

    public void setuBackJoint(int uBackJoint) {
        this.uBackJoint = uBackJoint;
    }

    public int getuCancer() {
        return uCancer;
    }

    public void setuCancer(int uCancer) {
        this.uCancer = uCancer;
    }

    public int getuDiabetes() {
        return uDiabetes;
    }

    public void setuDiabetes(int uDiabetes) {
        this.uDiabetes = uDiabetes;
    }

    public int getuFertility() {
        return uFertility;
    }

    public void setuFertility(int uFertility) {
        this.uFertility = uFertility;
    }

    public int getuHeadache() {
        return uHeadache;
    }

    public void setuHeadache(int uHeadache) {
        this.uHeadache = uHeadache;
    }

    public int getuHeart() {
        return uHeart;
    }

    public void setuHeart(int uHeart) {
        this.uHeart = uHeart;
    }

    public int getuHypertension() {
        return uHypertension;
    }

    public void setuHypertension(int uHypertension) {
        this.uHypertension = uHypertension;
    }

    public int getuInsomnia() {
        return uInsomnia;
    }

    public void setuInsomnia(int uInsomnia) {
        this.uInsomnia = uInsomnia;
    }

    public int getuNarcolepsy() {
        return uNarcolepsy;
    }

    public void setuNarcolepsy(int uNarcolepsy) {
        this.uNarcolepsy = uNarcolepsy;
    }

    public int getuSkin() {
        return uSkin;
    }

    public void setuSkin(int uSkin) {
        this.uSkin = uSkin;
    }

    public int getuSnore() {
        return uSnore;
    }

    public void setuSnore(int uSnore) {
        this.uSnore = uSnore;
    }

    public int getuThyroid() {
        return uThyroid;
    }

    public void setuThyroid(int uThyroid) {
        this.uThyroid = uThyroid;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWorkActivity() {
        return workActivity;
    }

    public void setWorkActivity(int workActivity) {
        this.workActivity = workActivity;
    }
}