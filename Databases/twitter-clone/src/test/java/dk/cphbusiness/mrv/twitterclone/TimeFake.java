package dk.cphbusiness.mrv.twitterclone;

import dk.cphbusiness.mrv.twitterclone.util.Time;

public class TimeFake implements Time {
    private long time;

    public void setCurrentTime(long t) {
        this.time = t;
    }

    @Override
    public long getCurrentTimeMillis() {
        return time;
    }
}
