package cz.unicorncollege.controller;

import java.util.*;

import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.FileParser;

public class MeetingController extends Controller{
	public static final String DATA_STORE = "data.csv";
	private List<MeetingCentre> meetingCentres;
	/**
	 * Method to initialize data from the saved datafile.
	 */
	public void init(){
		//TODO: nacist z ulozeneho souboru vsechna meeting centra a vypsat je na obrazovku
		meetingCentres = FileParser.loadDataFromFile(DATA_STORE);
	}


	private void printCenters(){
		System.out.println();
		meetingCentres.forEach(meetingCentre -> printCenter(meetingCentre));
		System.out.println();
	}

	private void printCenter(MeetingCentre center){
		System.out.println("code: " + center.getCode() + ", name: " + center.getName());
		/*System.out.println("	-" + center.getDescription());
		System.out.println("contains rooms:");
		center.getMeetingRooms().forEach(meetingRoom -> {printRoom(meetingRoom);});*/
	}



	public void showRooms(MeetingCentre meetingCentre){
		meetingCentre.getMeetingRooms().forEach(this::showRoomDetail);
	}

	private void showRoomDetail(MeetingRoom room) {
		System.out.println("name: " + room.getName() + ", description: " +room.getDescription() +System.getProperty("line.separator"));
	}

	public List<MeetingCentre> getMeetingCentres() {
		return meetingCentres;
	}

	public void setMeetingCentres(List<MeetingCentre> meetingCentres) {
		this.meetingCentres = meetingCentres;
	}

	public static class InputCannotBeEmptyException extends RuntimeException{}
}
