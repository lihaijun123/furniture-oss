function Browser(){
	var d_ = document,n_ = navigator,t_ = this,s_= screen;
	var b = n_.appName;
	var ua = n_.userAgent.toLowerCase();
	t_.name = "Unknow";
	t_.safari = ua.indexOf("safari")>-1;  // always check for safari & opera
	t_.opera = ua.indexOf("opera")>-1;    // before ns or ie
	t_.firefox = !t_.safari  &&  ua.indexOf('firefox')>-1; // check for gecko engine
	t_.ns = !t_.firefox  &&  !t_.opera  &&  !t_.safari  &&  (b=="Netscape");
	t_.ie = !t_.opera  &&  (b=="Microsoft Internet Explorer");
	t_.name = (t_.ie ? "IE" : (t_.firefox ? "Firefox" : (t_.ns ? "Netscape" : (t_.opera ? "Opera" : (t_.safari ? "Safari" : "Unknow")))));
}
function JShortCut(){
	var self;
	var map = {};
	var brw = new Browser();
	this.bind = function(sc,func,doSysSc){
		map[sc] = func;
		if(doSysSc === false)
			map[sc].doSysShortCut = false;
	}
	this.unBind = function(sc){
		delete map[sc];
	}
	this.listen = function(elm){
		if(typeof elm == "string") elm = document.getElementById(elm);
		if (elm.addEventListener) {
			//Safari,opera,firefox
			elm.addEventListener("keydown", dispatch, false);
			elm.addEventListener("keypress", dispatch, false);
		} else if (elm.attachEvent) {
			//IE
			elm.attachEvent("onkeydown", dispatch);
			elm.attachEvent("onkeypress", dispatch);
		} else {
			elm.onkeydown = element.onkeypress = dispatch;
		}
	}
	var dispatch = function (evt){
		evt = evt || event;
		if (evt.type == "keydown") {
			var code = evt.keyCode;
			if (code == 16 || code == 17 || code == 18) return;
			keyname = JShortCut.KEYS[code];
			var modifiers = "";
			if (!keyname  &&  (evt.altKey || evt.ctrlKey))
				//keyname = Keymap.keyCodeToPrintableChar[code];
			if (keyname) {
				if (evt.altKey) modifiers += "alt_";
				if (evt.ctrlKey) modifiers += "ctrl_";
				if (evt.shiftKey) modifiers += "shift_";
			}else{
				return;
			}
		}else if (evt.type == "keypress") {
			if (evt.altKey || evt.ctrlKey) return;
			if (evt.charCode != undefined  &&  evt.charCode == 0) return;
			var code = evt.charCode || evt.keyCode;
			keyname=String.fromCharCode(code);
			var lowercase = keyname.toLowerCase( );
			if (keyname != lowercase) {
				keyname = lowercase;    // Use the lowercase form of the name
				modifiers = "shift_";   // and add the shift modifier.
			}
		}
		var shortCut = modifiers+keyname;
		var target = evt.srcElement || evt.target;
		var func = map[shortCut];
		if(typeof func == "function"){
			func(target,shortCut,evt);
			if(func.doSysShortCut === false){
				switch(brw.name){
				case "IE":
					evt.returnValue = false;
					evt.keyCode = 0;
					break;
				case "Firefox":
					evt.preventDefault();
					break;
				case "Opera":
					evt.returnValue = false;
					evt.preventDefault();
					break;
				case "Safari":
					evt.preventDefault();
					evt.returnValue = false;
					//for(o in evt)
					// document.write(o," ",typeof(eval("evt." + o))," = ",eval("evt." + o),"<br />");
				}
			}
		}
		//return false;
	}
}
JShortCut.KEYS = {
    48:"0", 49:"1", 50:"2", 51:"3", 52:"4", 53:"5", 54:"6", 55:"7", 56:"8",
    57:"9", 59:";", 61:"=", 65:"a", 66:"b", 67:"c", 68:"d",
    69:"e", 70:"f", 71:"g", 72:"h", 73:"i", 74:"j", 75:"k", 76:"l", 77:"m",
    78:"n", 79:"o", 80:"p", 81:"q", 82:"r", 83:"s", 84:"t", 85:"u", 86:"v",
    87:"w", 88:"x", 89:"y", 90:"z", 107:"+", 109:"-", 110:".", 188:",",
    190:".", 191:"/", 192:"'", 219:"[", 220:"\\", 221:"]", 222:"\"",
    8:"backspace",  9:"tab",   13:"return",    19:"pause",  27:"escape",  32:"space",
    33:"pageup",  34:"pagedown",  35:"end",     36:"home",   37:"left",   38:"up",
    39:"right",  40:"down",   44:"printscreen",   45:"insert",  46:"delete",
    112:"f1",   113:"f2",   114:"f3", 115:"f4",  116:"f5",   117:"f6",   118:"f7",
    119:"f8",   120:"f9",   121:"f10", 122:"f11",  123:"f12",
    144:"numlock",  145:"scrolllock"
};