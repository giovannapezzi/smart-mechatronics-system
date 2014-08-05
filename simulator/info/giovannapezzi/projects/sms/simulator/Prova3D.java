package info.giovannapezzi.projects.sms.simulator;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

public class Prova3D {
	public static void main(String[] args) {
		SimpleUniverse universe = new SimpleUniverse();
        universe.getViewingPlatform().setNominalViewingTransform();
        
        ColorCube cube = new ColorCube(0.3);
        
        Transform3D transformation1 = new Transform3D();
        // transformation1.setTranslation(new Vector3f(.0f, .0f, .0f));
        transformation1.rotX(0.3);
         
        Transform3D transformation2 = new Transform3D();
        // transformation2.setRotation(new Quat4f(-1f, 0f, .0f, .3f));
        transformation2.rotY(0.3);
        
        TransformGroup transformationsGroup1 = new TransformGroup();
        transformationsGroup1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transformationsGroup1.setTransform(transformation1);
        
        TransformGroup transformationsGroup2 = new TransformGroup();
        transformationsGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transformationsGroup2.setTransform(transformation2);        
        
        BranchGroup group = new BranchGroup();
        group.addChild(transformationsGroup1);
        transformationsGroup1.addChild(transformationsGroup2);
        transformationsGroup2.addChild(cube);
        
        universe.addBranchGraph(group);
        
        transformation1.rotY(0.6);
        transformationsGroup1.setTransform(transformation1);
	}
}