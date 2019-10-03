package server;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import models.Record;
import models.SongItem;

public class SongLibraryServices {
	
	private static SongLibrary mSongLibrary;
	
		public SongLibraryServices() {
			mSongLibrary = SongLibrary.getInstance();
		}
		
		public String searchForSong(String searchParam, String pageNumber) {
			ArrayList<SongItem> items = new ArrayList<SongItem>();
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			
			for(String recordId : mSongLibrary.getKeySet()) {
				Record record = mSongLibrary.getRecord(recordId);
				if(record.getArtist().getName().contains(searchParam) || record.getSong().getTitle().contains(searchParam)) {
					items.add(new SongItem(record.getSong().getTitle(), record.getArtist().getName(), record.getSong().getId(), record.getRelease().getName()));
					//sb.append(new SongItem(record.getSong().getTitle(), record.getArtist().getName(), record.getSong().getId(), record.getRelease().getName()).toJsonString());

				}			
			}
			
			int start = (Integer.parseInt(pageNumber) - 1) * 6;
			for(int i = start; i < start + 6; i++) {
				if(items.size() > i) {
					Gson gson = new Gson();
					sb.append(gson.toJson(items.get(i)));
				}
			}
			
			sb.append("]");
			return sb.toString();
		}
	
	

}
