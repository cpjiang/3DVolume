// Prototype plugin tool. There are more plugin tools at
// http://imagej.nih.gov/ij/plugins/index.html#tools
import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.tool.PlugInTool;
import java.awt.event.*;

public class C_Tool extends PlugInTool {
	public static final int RED = 4;
	public static final int GREEN = 1;
	public static final int BLUE = 3;
	public static final int GREY = 2;

	public void mousePressed(ImagePlus imp, MouseEvent e) {
		IJ.log("mousepressed: "+e);
		IJ.log("here here here");
		int imgX = imp.getCanvas().offScreenX(e.getX());
		int imgY = imp.getCanvas().offScreenY(e.getY());
		showXY(imgX, imgY);
	}

	public void mouseDragged(ImagePlus imp, MouseEvent e) {
		IJ.log("mouse dragged: "+e);
	}

	public void showOptionsDialog() {
		IJ.log("icon double-clicked");
		showStackInfo();
	}
	
	public void showXY(int x, int y) {
		IJ.log("X = " + x + " Y = " + y + "\n");
		tryout(x, y);
	}
	
	public void showStackInfo() {
		ImagePlus imagePlus = IJ.getImage();
		int dimentions[] = imagePlus.getDimensions();
		IJ.log("Dimentions = (width = " + dimentions[0]
				+ ", height = " + dimentions[1]
				+ ", channels = " + dimentions[2]
				+ ", slices = " + dimentions[3]
				+ ", frames = " + dimentions[4]
				+ ")\n");
	}
	public void tryout(int x, int y) {
		ImagePlus imagePlus = IJ.getImage();
		ImageStack imageStack = imagePlus.getImageStack();
		int currentSlice = imagePlus.getSlice();
		
		double voxelR = imageStack.getVoxel(x,  y,  imagePlus.getStackIndex(RED, currentSlice, 1));
		double voxelG = imageStack.getVoxel(x,  y,  imagePlus.getStackIndex(GREEN, currentSlice, 1));
		double voxelB = imageStack.getVoxel(x,  y,  imagePlus.getStackIndex(BLUE, currentSlice, 1));
		double voxelGrey = imageStack.getVoxel(x,  y,  imagePlus.getStackIndex(GREY, currentSlice, 1));
		
		IJ.log("Voxel(" + x + "," + y + "," + currentSlice + ") = " + voxelR + "/" + voxelG + "/" + voxelB + "/" + voxelGrey);
	}
	
}
