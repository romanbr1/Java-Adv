package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Levels;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Ivan");
		participant1.setEmail("Ivan@iv.iv");
		participant1.setLevel(Levels.L3);
		participant1.setPrimarySkill("read");
		
		Participant participant2 = new Participant();
		
		participant2.setId(2);
		participant2.setName("Stepan");
		participant2.setEmail("Stepan@iv.iv");
		participant2.setLevel(Levels.L5);
		participant2.setPrimarySkill("write");
		

		participants.add(participant1);
		participants.add(participant2);
		
	}

	public List<Participant> findAllPaticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, participantToUpdate);
		} else {
			// save
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
