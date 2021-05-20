package dk.cphbusiness.mrv.twitterclone.util;

public class TimeImpl implements Time {
    @Override
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
