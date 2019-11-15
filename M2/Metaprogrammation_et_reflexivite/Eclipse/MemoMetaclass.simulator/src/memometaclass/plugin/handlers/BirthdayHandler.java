package memometaclass.plugin.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import memoMetaclass.MemoMetaclassPackage;
import memoMetaclass.World;

import org.eclipse.jface.dialogs.MessageDialog;

public class BirthdayHandler extends AbstractHandler
{
	private static final String modelPath = "C:\\Users\\Thomas\\Documents\\Repositories\\GitHub\\TP\\M2\\Metaprogrammation_et_reflexivite\\Eclipse\\MemoMetaclass.model\\Model.memometaclass";
	
	private static ResourceSet resourceSet = null;
	
	private static EObject loadModel() throws IOException
	{
		XMIResourceImpl resource = new XMIResourceImpl();
		resourceSet.getResources().add(resource);
		resource.doLoad(new FileInputStream(new File(modelPath)),
				new HashMap<Object, Object>());
		
		return resource.getContents().get(0);
	}
	
	private static void saveModel(EObject container) throws IOException
	{
		FileOutputStream stream = new FileOutputStream(new File(modelPath));
		container.eResource().save(stream, new HashMap<Object, Object>());
	}
	
	private static void initResourceSet()
	{
		if (resourceSet != null)
			return;
		
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put("http://www.example.org/memo", MemoMetaclassPackage.eINSTANCE);
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("http://www.example.org/incrementation"),
				URI.createURI(MemoMetaclassPackage.eINSTANCE.getNsURI()));
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		initResourceSet();
		
		try
		{
			World world = (World) loadModel();
			world.getPopulation().forEach(person -> person.birthday());
			saveModel(world);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Plugin",
				"Happy birthday!");
		
		return null;
	}
}
