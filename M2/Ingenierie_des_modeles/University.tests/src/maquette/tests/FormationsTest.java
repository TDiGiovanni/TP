/**
 */
package maquette.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import maquette.Formations;
import maquette.MaquetteFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Formations</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormationsTest extends TestCase {

	/**
	 * The fixture for this Formations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Formations fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FormationsTest.class);
	}

	/**
	 * Constructs a new Formations test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormationsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Formations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Formations fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Formations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Formations getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MaquetteFactory.eINSTANCE.createFormations());
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

} //FormationsTest
