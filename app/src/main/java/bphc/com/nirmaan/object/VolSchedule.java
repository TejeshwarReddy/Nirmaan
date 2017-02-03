package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class VolSchedule extends RealmObject{

    @PrimaryKey
    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @SerializedName("scheduled_visit")
    @Expose
    private Long scheduledVisit;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("chapter_number")
    @Expose
    private String chapterNumber;
    @SerializedName("chapter_name")
    @Expose
    private String chapterName;
    @SerializedName("reference")
    @Expose
    private String reference;
    @Ignore
    private GregorianCalendar mCalendar;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolSchedule() {
        mCalendar = new GregorianCalendar();
        mCalendar.setTimeInMillis(scheduledVisit);
    }

    /**
     * 
     * @param scheduledVisit
     * @param chapterNumber
     * @param _class
     * @param subject
     * @param topicId
     * @param chapterName
     * @param reference
     */
    public VolSchedule(String topicId, Long scheduledVisit, String _class, String subject, String chapterNumber, String chapterName, String reference) {
        super();
        this.topicId = topicId;
        this.scheduledVisit = scheduledVisit;
        this._class = _class;
        this.subject = subject;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.reference = reference;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Long getScheduledVisit() {
        return scheduledVisit;
    }

    /**
     * @return Date as String, pattern: 8 February, 1997
     */
    public String getDate() {
        int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
        String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int year = mCalendar.get(Calendar.YEAR);
        return Integer.toString(dayOfMonth) + " " + month + ", " + Integer.toString(year);
    }

    /**
     * @return Day as String, pattern: Saturday
     */
    public String getDay() {
        return mCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    /**
     * @return Time as String, pattern: 9:15 AM
     */
    public String getTime() {

        int hour = mCalendar.get(Calendar.HOUR);
        int minute = mCalendar.get(Calendar.MINUTE);
        String amPm = mCalendar.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
        return Integer.toString(hour) + ":" + Integer.toString(minute) + " " + amPm;
    }

    public void setScheduledVisit(Long scheduledVisit) {
        this.scheduledVisit = scheduledVisit;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}