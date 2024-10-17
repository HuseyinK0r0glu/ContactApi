package hk.contactapi.service;

import hk.contactapi.domain.Contact;
import hk.contactapi.repo.ContactRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
// provided by the Lombok library,it automatically generates a logger field for logging purposes
@Slf4j
//  This attribute specifies the type of exceptions that will trigger a rollback of the transaction
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepo contactRepo;
    // "page" refers to pagination, which is a technique used in databases to retrieve large datasets in smaller, more manageable chunks or pages
    //Represents a specific subset of the total data
    public Page<Contact> getAllContact(int page, int size){
        return contactRepo.findAll(PageRequest.of(page,size, Sort.by("name")));
    }

    public Contact getContact(String id){
        return contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public Contact createContact(Contact contact){
        return contactRepo.save(contact);
    }

    public void deleteContact(Contact contact){
        contactRepo.delete(contact);
    }
}
