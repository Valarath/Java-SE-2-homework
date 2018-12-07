package cz.unicorncollege.bt.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;

public class FileParser {

	private static final String CSV_SEPARATOR = ",";
	public static final int MEETING_CENTER_ATTRIBUTE_COUNT = 3;
	public static final int MEETING_ROOM_ATTRIBUTE_COUNT = 6;

	/**
	 * Method to import data from the chosen file.
	 */
	public static List<MeetingCentre> importData() {
		//TODO: import dat ze souboru
		String locationFilter = Choices.getInput("Enter path of imported file: ");
		List<MeetingCentre> allMeetingCentres = loadDataFromFile(locationFilter);
		printMessage("Data was imported. " + allMeetingCentres.size() + " objects of MeetingCentres was loaded");
		return allMeetingCentres;
	}
	
	/**
	 * Method to save the data to file.
	 */
	public static void saveData(String output, String dataToSave) {
		//TODO: ulozeni dat do souboru
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
			bufferedWriter.write(dataToSave);
			printMessage("Data was saved correctly.");
		} catch (IOException e) {
			handleException(e);
		}
	}
	
	/**
	 * Method to load the data from file.
	 * @return
	 */
	public static List<MeetingCentre> loadDataFromFile(String input) {
		//TODO: nacist data ze souboru
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
			return getMeetingCenters(bufferedReader.lines());
		} catch (IOException e) {
			handleException(e);
		}
		return new ArrayList<>();
	}

	private static void handleException(IOException e){
		if(e instanceof FileNotFoundException)
			System.out.println("Datasource for meeting centers is unavailable");
		else
			e.printStackTrace();
	}

	private static List<MeetingCentre> getMeetingCenters( Stream<String> lines) throws IOException {
		List<MeetingCentre> meetingCentres = new ArrayList<>();
		lines.forEach(line-> {
			parseLine(meetingCentres, line);
		});
		printMessage("Data was loaded correctly.");
		return meetingCentres;
	}

	private static void parseLine(List<MeetingCentre> meetingCentres, String line) {
		if (isMeetingCenter(line))
			meetingCentres.add(toMeetingCenter(line));
		else if (isMeetingRoom(line))
			toMeetingRoom(line,meetingCentres);
	}

	private static boolean isMeetingRoom(String line){
		String[] tokens = trimLine(line.split(CSV_SEPARATOR));
		return tokens.length== MEETING_ROOM_ATTRIBUTE_COUNT;
	}

	private static MeetingRoom toMeetingRoom(String line,List<MeetingCentre> meetingCentres){
		String[] tokens = line.split(CSV_SEPARATOR);
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setName(tokens[0]);
		meetingRoom.setCode(tokens[1]);
		meetingRoom.setDescription(tokens[2]);
		meetingRoom.setCapacity(Integer.parseInt(tokens[3]));
		meetingRoom.setVideoConference(hasVideoConference(tokens[4]));
		assignToBuilding(meetingRoom,tokens[5],meetingCentres);
		return meetingRoom;

	}

	private static void assignToBuilding(MeetingRoom meetingRoom,String buildingCode,List<MeetingCentre> meetingCentres){
		MeetingCentre building = getMeetingCenterByCode(meetingCentres, buildingCode);
		meetingRoom.setMeetingCentre(building);
		building.getMeetingRooms().add(meetingRoom);
	}

	private static MeetingCentre getMeetingCenterByCode(List<MeetingCentre> meetingCentres,String code){
		for (MeetingCentre meetingCentre: meetingCentres)
			if(meetingCentre.getCode().equals(code))
				return meetingCentre;
		throw new RoomWithoutBuildingException();
	}

	private static boolean hasVideoConference(String token){
		return token.equals("yes");
	}

	private static List<MeetingCentre> parseOnlyMeetingCenters(Stream<String> lines) {
		return lines
				.filter(FileParser::isMeetingCenter)
				.map(FileParser::toMeetingCenter)
				.collect(Collectors.toList());
	}

	private static boolean isMeetingCenter(String line){
		String[] tokens = trimLine(line.split(CSV_SEPARATOR));
		return tokens.length== MEETING_CENTER_ATTRIBUTE_COUNT;
	}

	private static MeetingCentre toMeetingCenter(String line){
		String[] tokens = line.split(CSV_SEPARATOR);
		MeetingCentre meetingCentre = new MeetingCentre();
		meetingCentre.setName(tokens[0]);
		meetingCentre.setCode(tokens[1]);
		meetingCentre.setDescription(tokens[2]);
		return meetingCentre;
	}

	private static void printMessage(String message){
		System.out.println();
		System.out.println("**************************************************");
		System.out.println(message);
		System.out.println("**************************************************");
		System.out.println();
	}

	private static String[] trimLine(String[] line){
		return Arrays.stream(line)
				.filter(x -> !x.isEmpty())
				.toArray(String[]::new);
	}

	private static class RoomWithoutBuildingException extends RuntimeException{}
}
