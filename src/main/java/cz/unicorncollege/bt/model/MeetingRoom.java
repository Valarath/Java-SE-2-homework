package cz.unicorncollege.bt.model;

public class MeetingRoom extends MeetingObject {
	private int capacity;	
	private boolean videoConference;
	private MeetingCentre meetingCentre;

	public StringBuilder toCsv(StringBuilder builder){
		return super.toCsv(builder.append(System.getProperty("line.separator")))
				.append(capacity).append(",")
				.append(toString(videoConference)).append(",")
				.append(meetingCentre.getCode());
	}

	private String toString(boolean bolean){
		return bolean?"yes":"no";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean hasVideoConference() {
		return videoConference;
	}

	public void setVideoConference(boolean videoConference) {
		this.videoConference = videoConference;
	}

	public MeetingCentre getMeetingCentre() {
		return meetingCentre;
	}

	public void setMeetingCentre(MeetingCentre meetingCentre) {
		this.meetingCentre = meetingCentre;
	}	
}
