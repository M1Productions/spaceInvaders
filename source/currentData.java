import java.text.SimpleDateFormat;
import java.util.Date;

class CurrentData
{
  static int sessionID, runID;
  static String username;
  static char[] keys = {'<','>','^'};


  static void setUser(String username)
  { CurrentData.username = username; }
  static String getUsername()
  { return CurrentData.username; }

  static void setSession(int sessionID)
  { CurrentData.sessionID = sessionID; }
  static int getSessionID()
  { return CurrentData.sessionID; }

  static void setRun(int runID)
  { CurrentData.runID = runID; }
  static int getRunID()
  { return CurrentData.runID; }

  static void changeKey(int pos , String key)
  { CurrentData.keys[pos] = key.charAt(0); }
  static void setKeys(char[] keys)
  { CurrentData.keys = keys; }
  static char[] getKeys()
  { return CurrentData.keys; }
}
