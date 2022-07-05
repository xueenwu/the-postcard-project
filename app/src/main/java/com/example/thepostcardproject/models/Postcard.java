package com.example.thepostcardproject.models;

import static com.example.thepostcardproject.utilities.Keys.KEY_COVER_PHOTO;
import static com.example.thepostcardproject.utilities.Keys.KEY_LOCATION_FROM;
import static com.example.thepostcardproject.utilities.Keys.KEY_LOCATION_TO;
import static com.example.thepostcardproject.utilities.Keys.KEY_MESSAGE;
import static com.example.thepostcardproject.utilities.Keys.KEY_USER_FROM;
import static com.example.thepostcardproject.utilities.Keys.KEY_USER_TO;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Comparator;

@ParseClassName("Postcard")
public class Postcard extends ParseObject {

    public Postcard() { super(); }

    public Postcard(ParseFile coverPhoto, ParseUser userFrom, ParseUser userTo, ParseObject locationFrom, ParseObject locationTo, String message) {
        super();
        setCoverPhoto(coverPhoto);
        setUserFrom(userFrom);
        setUserTo(userTo);
        setLocationFrom(locationFrom);
        setLocationTo(locationTo);
        setMessage(message);
    }

    public ParseFile getCoverPhoto() {
        return getParseFile(KEY_COVER_PHOTO);
    }

    public void setCoverPhoto(ParseFile coverPhoto) {
        put(KEY_COVER_PHOTO, coverPhoto);
    }

    public User getUserFrom() throws ParseException {
        return (User) fetchIfNeeded().getParseUser(KEY_USER_FROM);
    }

    public void setUserFrom(ParseUser userFrom) {
        put(KEY_USER_FROM, userFrom);
    }

    public User getUserTo() throws ParseException {
        return (User) fetchIfNeeded().getParseUser(KEY_USER_TO);
    }

    public void setUserTo(ParseUser userTo) {
        put(KEY_USER_TO, userTo);
    }

    public Location getLocationFrom() {
        return (Location) getParseObject(KEY_LOCATION_FROM);
    }

    public void setLocationFrom(ParseObject locationFrom) {
        put(KEY_LOCATION_FROM, locationFrom);
    }

    public Location getLocationTo() {
        return (Location) getParseObject(KEY_LOCATION_TO);
    }

    public void setLocationTo(ParseObject locationTo) {
        put(KEY_LOCATION_TO, locationTo);
    }

    public String getMessage() {
        return getString(KEY_MESSAGE);
    }

    public void setMessage(String message) {
        put(KEY_MESSAGE, message);
    }
}
