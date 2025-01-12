package com.j2htmx.inline.html.standard.form;


import com.j2htmx.inline.html.nodes.NodeCreator;

public class Button extends NodeCreator {
	String disable = "";
	String areaLabel = "";
	String onclick = "";
	String hxSwap = "";

    public Button() {
		setTag("button");
    }

    @Override
	public String createPairNode(){
		return "<"+this.Tag+classStyle+style+name+hxSwap+hxOutOfOrderSwap+onclick+id+width+height+hxGet+hxVals+hxInclude+hxTarget+hxTrigger+disable+areaLabel+" >"+ this.content   + "</"+this.Tag+">";
	}

	public void toggleButtonDisable() {
		this.disable = " disabled ";
	}

	public Button(String content, String clientId) {
		setContent(content);
		setClientId(clientId);
		setTag("button");
	}

	public Button(String clientId) {
		setClientId(clientId);
		setTag("button");
	}
	public Button(String content, String clientId, String hxPost, String hxTarget) {
		setContent(content);
		setClientId(clientId);
		setHxGet(hxPost);
		setHxTarget(hxTarget);
		setTag("button");
	}

	public void setOnclick(String jsFunction) {
		this.onclick = " onclick = " + jsFunction;
	}

	public void setHxSwap(String swap) {
		this.hxSwap = " hx-swap = " + swap;
	}

	public void setAreaLabel(String areaLabel) {
		this.areaLabel = "aria-label = " + areaLabel;
	}
}
