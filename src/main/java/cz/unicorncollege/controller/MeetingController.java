package cz.unicorncollege.controller;

import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.FileParser;

import java.util.List;

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

	public List<MeetingCentre> getMeetingCentres() {
		return meetingCentres;
	}

	public void setMeetingCentres(List<MeetingCentre> meetingCentres) {
		this.meetingCentres = meetingCentres;
	}
}
