package no.onlevel.deler.gui.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.onlevel.deler.facade.DelerFacade;

public class DelerController extends Application {

	private static final int TERMINER_I_AARET_12 = 12;
	private static final String FXML = "/no/onlevel/annuitetslaan/view/Annuitetsberegning.fxml";
	private static final String LAAN_Randi = "../data/endringer_Randi.xml";
	private static final String LAAN_HELE = "../data/endringer_laan.xml";
	private static final String LAAN_2MILL = "../data/endringer_2Mill.xml";
		
	// Spring ???
	private DelerFacade laanFacade = new DelerFacade();

	
	private Stage primaryStage;
	private Pane beregneAnnuitet;
//	private ObservableList<TerminRad> terminRader;
//	private ObservableList<NedbetalingRad> innbetalingRader;
//	private ObservableList<RenteendringRad> renteendringRader;
//	private ObservableList<TerminkostRad> terminkostRader;

	public static void main(String[] args) {
		launch(args); // returnerer når applikasjonen avsluttes
	}

	// @FXML knytter kontroller i .fxml-fila til variabler i controller
	// Dermed er controller knyttet tett på gui og kontroller kan gjøre mye
	// cui-relatert....

	@FXML
	private Button randisLaan;

	@FXML
	private Button heleLaanet;

	@FXML
	private Button toMill;

	@FXML
	private Pane vindu;

	@FXML
	private Label resultat;

	@FXML
	private TextField laan;

	@FXML
	private TextField rente;

	@FXML
	private TextField aarLopetid;

	@FXML
	private TextField etableringsgebyr;

	@FXML
	private TextField termingebyr;

	@FXML
	private Label utgifterPrMaaned;

	@FXML
	private DatePicker startdato;

//	@FXML
//	private TableView<TerminRad> nedbetalingstabell;
//	@FXML
//	private TableColumn<TerminRad, String> maanedKol;
//	@FXML
//	private TableColumn<TerminRad, String> terminKol;
//	@FXML
//	private TableColumn<TerminRad, String> renterKol;
//	@FXML
//	private TableColumn<TerminRad, String> avdragKol;
//	@FXML
//	private TableColumn<TerminRad, String> restlaanKol;
//
//	@FXML
//	private TableView<NedbetalingRad> innbetalingstabell;
//	@FXML
//	private TableColumn<NedbetalingRad, String> innbetalingsdatoKol;
//	@FXML
//	private TableColumn<NedbetalingRad, String> innbetaltKol;
//
//	@FXML
//	private TableView<RenteendringRad> renteendringstabell;
//	@FXML
//	private TableColumn<RenteendringRad, String> rentedatoKol;
//	@FXML
//	private TableColumn<RenteendringRad, String> renteKol;
//
//	@FXML
//	private TableView<TerminkostRad> terminkostnadertabell;
//	@FXML
//	private TableColumn<TerminkostRad, String> terminkostdatoKol;
//	@FXML
//	private TableColumn<TerminkostRad, String> terminkostKol;

	// setup
	@Override
	public void start(Stage hovedScene) throws IOException {
		// .init() kjøres før .start()
		this.primaryStage = hovedScene;
		this.primaryStage.setTitle("Beregn App");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(DelerController.class.getResource(FXML));

		beregneAnnuitet = (Pane) loader.load();

		// Show the scene containing the layout.
		Scene akt = new Scene(beregneAnnuitet);
		hovedScene.setScene(akt);
		hovedScene.show();
		// Spring
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(CustomerAppConfiguration.class);
		// ScreensConfiguration screens =
		// context.getBean(ScreensConfiguration.class);
		// screens.setPrimaryStage(stage);
		// screens.loginDialog().show();
	}

	@Override
	public void init() {
		// start db
	}

	@Override
	public void stop() {
		// stop db
	}

	// populate
	@FXML
	public void initialize() {

//		terminRader = nedbetalingstabell.getItems(); // FXCollections.observableArrayList(
//		// hver kolonne MÅ ha en factory som binder <Klasse> sine properties til
//		// en kolonne
//		maanedKol.setCellValueFactory(new PropertyValueFactory<TerminRad, String>("maaned"));
//		terminKol.setCellValueFactory(new PropertyValueFactory<TerminRad, String>("innbetalt"));
//		renterKol.setCellValueFactory(new PropertyValueFactory<TerminRad, String>("renter"));
//		avdragKol.setCellValueFactory(new PropertyValueFactory<TerminRad, String>("avdrag"));
//		restlaanKol.setCellValueFactory(new PropertyValueFactory<TerminRad, String>("restlaan"));
//
//		innbetalingRader = innbetalingstabell.getItems();
//		innbetalingsdatoKol.setCellValueFactory(new PropertyValueFactory<NedbetalingRad, String>("dato"));
//		innbetaltKol.setCellValueFactory(new PropertyValueFactory<NedbetalingRad, String>("innbetaling"));
//
//		renteendringRader = renteendringstabell.getItems();
//		rentedatoKol.setCellValueFactory(new PropertyValueFactory<RenteendringRad, String>("dato"));
//		renteKol.setCellValueFactory(new PropertyValueFactory<RenteendringRad, String>("rente"));
//
//		terminkostRader = terminkostnadertabell.getItems();
//		terminkostdatoKol.setCellValueFactory(new PropertyValueFactory<TerminkostRad, String>("dato"));
//		terminkostKol.setCellValueFactory(new PropertyValueFactory<TerminkostRad, String>("kostnader"));
//
//		// populer
//		laanFacade.lesOppEndringer(LAAN_Randi);
//
//		laan.setText(laanFacade.hentLaan().toString());
//		rente.setText(laanFacade.hentRente().toString());
//		startdato.setValue(laanFacade.startDato());
//		aarLopetid.setText(laanFacade.lopetid().toString());
//		innbetalingRader.addAll(laanFacade.hentNedbetalinger());
//		renteendringRader.addAll(laanFacade.hentRenteendringer());
//
//		laanFacade.hentLaan();
//
//		terminkostRader.add(new TerminkostRad(LocalDate.of(2015, 3, 31), 50));
//
//		System.out.println(nedbetalingstabell.getColumns().get(1).getText());
	}

	@FXML
	public void visNedbetalingsplan(ActionEvent a) {
		Double laanebelop = Double.parseDouble(laan.getText());
		Double rentefot = Double.parseDouble(rente.getText().replaceFirst(",", "."));
		Integer lopetid = Integer.parseInt(aarLopetid.getText());
		LocalDate startDato = startdato.getValue();

//		List<TerminRad> terminListe = laanFacade.visNedbetalingsplan(laanebelop, rentefot, lopetid,
//				TERMINER_I_AARET_12, startDato);
//
//		// opprett rader
//		nedbetalingstabell.getItems().clear();
//		nedbetalingstabell.getItems().addAll(terminListe);
	}

	@FXML
	public void beregnLaan() {

	}

	@FXML
	public void beregnMedEndringer(ActionEvent a) {

//		if (a.getSource().equals(randisLaan)) { // bruker fx:id til å
//												// identifisere kilden
//			laanFacade.lesOppEndringer(LAAN_Randi);
//		}
//		if (a.getSource().equals(heleLaanet)) {
//			laanFacade.lesOppEndringer(LAAN_HELE);
//		}
//		if (a.getSource().equals(toMill)) {
//
//			laanFacade.lesOppEndringer(LAAN_2MILL);
//		}
//		laan.setText(laanFacade.hentLaan().toString());
//		rente.setText(laanFacade.hentRente().toString());
//		startdato.setValue(laanFacade.startDato());
//		aarLopetid.setText(laanFacade.lopetid().toString());
//
//		// les startbeløp, start dato og startrenter fra øverst i bildet
//		Double laanIni = Double.parseDouble(laan.getText());
//		Double renteIni = Double.parseDouble(rente.getText().replaceFirst(",", ".")) / 100.0;
//		Integer lopetid = Integer.parseInt(aarLopetid.getText());
//		LocalDate laanStartDato = startdato.getValue();
//		// Double gebyrIni = Double.parseDouble(termingebyr.getText());
//
//		// les renteendringeer og nedbetalinger
//		innbetalingRader.clear();
//		renteendringRader.clear();
//		List<NedbetalingRad> nedbetalingListe = laanFacade.hentNedbetalinger();
//		List<RenteendringRad> renteEndringListe = laanFacade.hentRenteendringer();
//		// oppdater gui
//		innbetalingRader.addAll(laanFacade.hentNedbetalinger());
//		renteendringRader.addAll(laanFacade.hentRenteendringer());
//
//		List<TerminRad> terminListe = laanFacade.lagNedbetalingsoversikt(laanIni, renteIni, lopetid, laanStartDato,
//				renteEndringListe, nedbetalingListe);
//
//		// opprett rader
//		nedbetalingstabell.getItems().clear();
//		nedbetalingstabell.getItems().addAll(terminListe);
	}

	/*
	 * når nedbetalinger skal beregnes - beregn gjenstående og trekk fra
	 * 
	 * g = mI * (1-(1+r)^(-n) )/r g = gjenstående lån mI = mndInnbetalig r =
	 * rente (som forholdstall) n = antall gjenstående trerminer
	 */

	/*
	 * Beregner gjenstående - ikke i bruk
	 */
	// private Double beregnGjenstaaende(int maanedligInnbetaling,
	// double rentefot, int antallGjenstaaendeTerminer) {
	// int m = maanedligInnbetaling;
	// double r = Math.pow(1 + (rentefot / 100), 12) - 1; // rente pr mnd
	// int n = antallGjenstaaendeTerminer;
	//
	// return m * (1 - Math.pow(1 + r, -n)) / r;
	// }
}
