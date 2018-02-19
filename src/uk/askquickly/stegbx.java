package uk.askquickly;
import android.graphics.Bitmap;
import com.stealthcopter.steganography.BitmapHelper;
import com.stealthcopter.steganography.Steg;
import com.stealthcopter.steganography.Test;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BA.Author;

@Author("Jamie John")
@Version(1.0f)
//embed this?
@DependsOn(values = {"support-annotations-25.3.0"})
@ShortName("f5")

public class stegbx {
	
private void go(){
    new Thread(new Runnable() {
      @Override public void run() {
        try {
          Test.runTests();
          testmode();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  private void testmode() throws Exception{
    String hiddenMessage = "Hello B4A this is a hidden message to test everything is working";
    Bitmap bitmap = BitmapHelper.createTestBitmap(200, 200);
    Bitmap encodedBitmap = Steg.withInput(bitmap).encode(hiddenMessage).intoBitmap();
    String decodedMessage = Steg.withInput(encodedBitmap).decode().intoString();
	BA.Log(decodedMessage);
  }
  public Bitmap encode(Bitmap bitmaps, String hiddenMessage) throws Exception{
  Bitmap encodedBitmap = Steg.withInput(bitmaps).encode(hiddenMessage).intoBitmap();
  return encodedBitmap;
  }
  public Bitmap decode(Bitmap bitmaps) throws Exception{
  String decodedMessage = Steg.withInput(bitmaps).decode().intoString();
  BA.Log(decodedMessage);
return bitmaps;
  }
  public void unittestb4a(){
	  go();
  }
}