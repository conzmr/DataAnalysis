
package data;
import java.util.ArrayList;

public class GdfNode {
	private String name, username, label, category, link;
	private boolean usersCanPost, visited;
	private float post_activity;
	private int fanCount, talkingAboutCount;
	private ArrayList<GdfNode> childNodes,parentNodes;
	private GdfNode tempParent;
	private float pageRank;
	private float pastPageRank;
	public GdfNode(String s){
		initialize(s);
		childNodes = new ArrayList<GdfNode>();
		parentNodes = new ArrayList<GdfNode>();
		pageRank = 1;
		pastPageRank = 500;
	}
	public String getName(){
		return name;
	}
	public String getUsername(){
		return username;
	}
	public String getLabel(){
		return label;
	}
	public void addNode(GdfNode node){
		childNodes.add(node);
	}
	public ArrayList<GdfNode> getChildNodes(){
		return childNodes;
	}
	public GdfNode getTempParent() {
		return tempParent;
	}
	public void setTempParent(GdfNode tempParent) {
		this.tempParent = tempParent;
	}
	public ArrayList<GdfNode> getParentNodes() {
		return parentNodes;
	}
	public void addParent(GdfNode parent){
		if(!parentNodes.contains(parent))
			parentNodes.add(parent);
	}
	public void resetNode(){
		visited = false;
		tempParent = null;
		pageRank = 1;
		pastPageRank = 500;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	private void initialize(String s){
		visited = false;
		String[] values = s.split(",");
		name = values[0];
		username = values[1];
		label = "";
		int extras = values.length - 8;
		for(int x = 2; x < extras + 2; x++){
			if(x != (extras + 1)){
				label += values[x] + ",";
			}else{
				label += values[x];
			}
		}
		label = label.substring(1, label.length()-1);
		category = values[extras + 2];
		post_activity = Float.parseFloat(values[extras + 3]);
		fanCount = Integer.parseInt(values[extras + 4]);
		talkingAboutCount = Integer.parseInt(values[extras + 5]);
		usersCanPost = (values[extras + 6].equals("yes"))?true:false;
		link = values[extras + 7];
	}
	public String toString(){
		String s = "Name: " + name + 
				"\nUsername: " + username + 
				"\nLabel: " + label + 
				"\nCategory: " + category +
				"\nUsers can post: " + usersCanPost +
				"\nPost activity: " + post_activity +
				"\nFan count: " + fanCount + 
				"\nTalking about count: " + talkingAboutCount +
				"\nLink: " + link + 
				"\nVisited: " + visited + "\n";
		s += "Child Nodes: {";
		if(!childNodes.isEmpty())
			s += "\n";
		for(GdfNode node : childNodes){
			s += "\t*" + node.getLabel().toString() + "\n";
		}
		s += "}\n";
		return s;
	}
	
}
