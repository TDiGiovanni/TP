/**
 */
package Maps.tests;

import Maps.MapsFactory;
import Maps.Pedestrian;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pedestrian</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PedestrianTest extends RoadTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PedestrianTest.class);
	}

	/**
	 * Constructs a new Pedestrian test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PedestrianTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Pedestrian test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Pedestrian getFixture() {
		return (Pedestrian)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MapsFactory.eINSTANCE.createPedestrian());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PedestrianTest
