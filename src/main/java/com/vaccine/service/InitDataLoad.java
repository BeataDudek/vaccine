package com.vaccine.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccine.model.Issue;
import com.vaccine.model.User;
import com.vaccine.model.VaccineCalendar;
import com.vaccine.repository.IssueRepository;
import com.vaccine.repository.UserRepository;
import com.vaccine.repository.VaccineCalendarRepository;
import com.vaccine.repository.VaccineRepository;

@Service
public class InitDataLoad {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private VaccineRepository vaccineRepository;

	@Autowired
	private VaccineCalendarRepository vaccineCalendarRepository;

	@PostConstruct
	public void init() {

		VaccineCalendar vaccineCalendar1 = new VaccineCalendar(1, "Gruźlica", 0);
		VaccineCalendar vaccineCalendar2 = new VaccineCalendar(2, "WZW Typu B", 0);
		VaccineCalendar vaccineCalendar3 = new VaccineCalendar(3, "WZW Typu B (2 dawka)", 2);
		VaccineCalendar vaccineCalendar4 = new VaccineCalendar(4, "BŁONICA", 2);
		VaccineCalendar vaccineCalendar5 = new VaccineCalendar(5, "TĘŻCOWI", 2);
		VaccineCalendar vaccineCalendar6 = new VaccineCalendar(6, "KRZTUŚCOWI", 2);
		VaccineCalendar vaccineCalendar9 = new VaccineCalendar(9, "BŁONICY (2 dawka)", 4);
		VaccineCalendar vaccineCalendar10 = new VaccineCalendar(10, "TĘŻCOWI (2 dawka)", 4);
		VaccineCalendar vaccineCalendar11 = new VaccineCalendar(11, "KRZTUŚCOWI (2 dawka)", 4);
		VaccineCalendar vaccineCalendar12 = new VaccineCalendar(12, "BŁONICY (3 dawka)", 6);
		VaccineCalendar vaccineCalendar13 = new VaccineCalendar(13, "TĘŻCOWI (3 dawka)", 6);
		VaccineCalendar vaccineCalendar14 = new VaccineCalendar(14, "KRZTUŚCOWI (3 dawka)", 6);
		VaccineCalendar vaccineCalendar15 = new VaccineCalendar(15, "WZW Typu B (3 dawka)", 7);
		VaccineCalendar vaccineCalendar16 = new VaccineCalendar(16, "ODRA", 14);
		VaccineCalendar vaccineCalendar17 = new VaccineCalendar(17, "SWINKA", 14);
		VaccineCalendar vaccineCalendar18 = new VaccineCalendar(18, "ROZYCZKA", 14);
		VaccineCalendar vaccineCalendar19 = new VaccineCalendar(19, "BŁONICY (4 dawka)", 17);
		VaccineCalendar vaccineCalendar20 = new VaccineCalendar(20, "TĘŻCOWI (4 dawka)", 17);
		VaccineCalendar vaccineCalendar21 = new VaccineCalendar(21, "KRZTUŚCOWI (4 dawka)", 17);

		vaccineCalendarRepository.save(vaccineCalendar1);
		vaccineCalendarRepository.save(vaccineCalendar2);
		vaccineCalendarRepository.save(vaccineCalendar3);
		vaccineCalendarRepository.save(vaccineCalendar4);
		vaccineCalendarRepository.save(vaccineCalendar5);
		vaccineCalendarRepository.save(vaccineCalendar6);
		vaccineCalendarRepository.save(vaccineCalendar9);
		vaccineCalendarRepository.save(vaccineCalendar10);
		vaccineCalendarRepository.save(vaccineCalendar11);
		vaccineCalendarRepository.save(vaccineCalendar12);
		vaccineCalendarRepository.save(vaccineCalendar13);
		vaccineCalendarRepository.save(vaccineCalendar14);
		vaccineCalendarRepository.save(vaccineCalendar15);
		vaccineCalendarRepository.save(vaccineCalendar16);
		vaccineCalendarRepository.save(vaccineCalendar17);
		vaccineCalendarRepository.save(vaccineCalendar18);
		vaccineCalendarRepository.save(vaccineCalendar19);
		vaccineCalendarRepository.save(vaccineCalendar20);
		vaccineCalendarRepository.save(vaccineCalendar21);

		Issue issue0 = new Issue(1,
				"Błonica",
				"Określana też jako dyfteryt, krup lub dławiec, jest ostrą i ciężką chorobą zakaźną, wywoływaną przez bakterie zwane maczugowcami błonicy (łac. Corynebacterium diphtheriae), które wytwarzają silną toksynę, zwaną toksyną błoniczą. Oprócz maczugowców błonicy, chorobę tę mogą wywoływać dwa inne gatunki maczugowców: Corynebacterium ulcerans i Corynebacterium pseudotuberculosis, również mające zdolność wytwarzania toksyny błoniczej.",
				"ból gardła, gorączka 38°C lub wyższą, dreszcze, ból głowy, uczucie zmęczenia, chrypa, kaszel",
				"Adacel, Boostrix, Boostrix Polio, Clodivac");

		Issue issue1 = new Issue(2,
				"Cholera",
				"Jest ostrą chorobą biegunkową wywoływaną przez bakterie tzw. przecinkowce cholery (Vibrio cholerae). Jest to choroba „brudnych rąk”: Do zakażenia dochodzi w skutek spożycia wody lub produktów spożywczych zanieczyszczonych kałem osób chorych lub bezobjawowych nosicieli",
				"biegunka, wymioty, kurczowe bóle mięśni",
				"DUKORAL");

		Issue issue2 = new Issue(3,
				"Odra",
				"Wirusowa choroba zakaźna, która bardzo łatwo się rozprzestrzenia wśród nieuodpornionych osób w każdym wieku i może powodować epidemię. Nie należy jej lekceważyć ponieważ powikłania z nią związane mogą być bardzo groźne. Źródłem zakażenia jest chory człowiek. Zakażenie szerzy się drogą kropelkową oraz przez bezpośrednią styczność z wydzieliną z jamy nosowo-gardłowej chorej osoby.",
				"ból gardła, gorączka, katar, suchy kaszel, złe samopoczucie",
				"M-M-RVAXPRO, Priorix, Priorix-Tetra");

		Issue issue3 = new Issue(4,
				"Grypa",
				"jest ostrą chorobą zakaźną, wywoływaną przez wirusy grypy. Do zakażenia dochodzi drogą kropelkową lub przez kontakt ze skażoną powierzchnią. Okres inkubacji wynosi 1-4 dni. Wirusy grypy atakują komórki nabłonka dróg oddechowych, w których się namnażają. W konsekwencji powodują ich zniszczenie, co z kolei ułatwia rozwój infekcji bakteryjnych.",
				"kaszel, ból gardła, katar, wysoka gorączka powyżej 38ºC, dreszcze, ból głowy, ból w klatce piersiowej, złe samopoczucie, brak łaknienia, nudności, wymioty",
				"Influvac Tetra, Vaxigrip Tetra, Fluarix Tetra");

		issueRepository.save(issue0);
		issueRepository.save(issue1);
		issueRepository.save(issue2);
		issueRepository.save(issue3);


		//Administrator 1
		User firstAdmin = new User(1, "John", "Omega", "admin", "admin", true, "Admin", null);
		userRepository.save(firstAdmin);
	}
}