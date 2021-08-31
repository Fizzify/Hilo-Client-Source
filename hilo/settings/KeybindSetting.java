package hilo.settings;

public class KeybindSetting extends Setting {
	
	public int code;
	
	public KeybindSetting(int keyCode) {
		this.name = "KeyBind";
		this.code = keyCode;
	}

	public int getKeyCode() {
		return code;
	}

	public void setKeyCode(int keyCode) {
		this.code = keyCode;
	}

}
