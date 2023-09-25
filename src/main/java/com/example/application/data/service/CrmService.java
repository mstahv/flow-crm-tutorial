package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import org.eclipse.serializer.Serializer;
import org.eclipse.serializer.SerializerFoundation;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service 
public class CrmService {

    private final Serializer<byte[]> serializer;

    CrmData crmData;

    Path file = Path.of("crmData.bin");

    public CrmService() {
        SerializerFoundation<?> foundation = SerializerFoundation.New();
        // Define the custom Java types that we want to serialize/deserialize
        foundation.registerEntityTypes(
                Company.class,
                Contact.class,
                Status.class,
                CrmData.class
        );

        serializer = Serializer.Bytes(foundation);

        if(file.toFile().exists()) {
            // a previous process has saved the data, read from disk
            try {
                crmData = serializer.deserialize(Files.readAllBytes(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // no previous data, create some demo data
            crmData = loadDemoData();
        }
    }

    private static CrmData loadDemoData() {
        CrmData d = new CrmData();
        d.getStatuses().add(new Status("Lead"));
        d.getStatuses().add(new Status("Prospect"));
        d.getStatuses().add(new Status("Customer"));
        d.getStatuses().add(new Status("Closed Lost"));
        d.getStatuses().add(new Status("Closed Won"));

        d.getCompanies().add(new Company("Phillips Van Heusen Corp."));
        d.getCompanies().add(new Company("Avaya Inc."));
        d.getCompanies().add(new Company("Laboratory Corporation of America Holdings"));
        d.getCompanies().add(new Company("AutoZone, Inc."));
        d.getCompanies().add(new Company("Linens 'n Things Inc."));

        addContact("eula.lane@jigrormo.ye", "Eula", "Lane", d);
        addContact("barry.rodriquez@zun.mm", "Barry", "Rodriquez", d);
        addContact("eugenia.selvi@capfad.vn", "Eugenia", "Selvi", d);
        addContact("alejandro.miles@dec.bn", "Alejandro", "Miles", d);
        addContact("cora.tesi@bivo.yt", "Cora", "Tesi", d);
        addContact("marguerite.ishii@judbilo.gn", "Marguerite", "Ishii", d);
        addContact("mildred.jacobs@joraf.wf", "Mildred", "Jacobs", d);
        addContact("gene.goodman@kem.tl", "Gene", "Goodman", d);
        addContact("lettie.bennett@odeter.bb", "Lettie", "Bennett", d);
        addContact("mabel.leach@lisohuje.vi", "Mabel", "Leach", d);
        addContact("jordan.miccinesi@duod.gy", "Jordan", "Miccinesi", d);
        addContact("marie.parkes@nowufpus.ph", "Marie", "Parkes", d);
        addContact("rose.gray@kagu.hr", "Rose", "Gray", d);
        addContact("garrett.stokes@fef.bg", "Garrett", "Stokes", d);
        addContact("barbara.matthieu@derwogi.jm", "Barbara", "Matthieu", d);
        addContact("jean.rhodes@wehovuce.gu", "Jean", "Rhodes", d);
        addContact("jack.romoli@zamum.bw", "Jack", "Romoli", d);
        addContact("pearl.holden@dunebuh.cr", "Pearl", "Holden", d);
        addContact("belle.montero@repiwid.si", "Belle", "Montero", d);
        addContact("olive.molina@razuppa.ga", "Olive", "Molina", d);
        addContact("minerva.todd@kulmenim.ad", "Minerva", "Todd", d);
        addContact("bobby.pearson@ib.kg", "Bobby", "Pearson", d);
        addContact("larry.ciappi@ba.lk", "Larry", "Ciappi", d);
        addContact("ronnie.salucci@tohhij.lv", "Ronnie", "Salucci", d);
        addContact("walter.grossi@tuvo.sa", "Walter", "Grossi", d);
        addContact("frances.koopmans@foga.tw", "Frances", "Koopmans", d);
        addContact("frances.fujimoto@uswuzzub.jp", "Frances", "Fujimoto", d);
        addContact("olivia.vidal@hivwerip.vc", "Olivia", "Vidal", d);
        addContact("edna.henry@gugusu.rw", "Edna", "Henry", d);
        addContact("lydia.brun@zedekak.md", "Lydia", "Brun", d);
        addContact("jay.blake@ral.mk", "Jay", "Blake", d);
        addContact("isabel.serafini@turuhu.bh", "Isabel", "Serafini", d);
        addContact("rebecca.carter@omjo.et", "Rebecca", "Carter", d);
        addContact("maurice.fabbrini@rig.bh", "Maurice", "Fabbrini", d);
        addContact("ollie.turnbull@sicewap.org", "Ollie", "Turnbull", d);
        addContact("jerry.hopkins@fo.mh", "Jerry", "Hopkins", d);
        addContact("nora.lyons@gegijap.na", "Nora", "Lyons", d);
        addContact("anne.weis@kuvesa.pe", "Anne", "Weis", d);
        addContact("louise.gauthier@lapahu.mt", "Louise", "Gauthier", d);
        addContact("lloyd.fani@zev.ru", "Lloyd", "Fani", d);
        addContact("maud.dunn@nabeaga.ni", "Maud", "Dunn", d);
        addContact("henry.gigli@kaot.ps", "Henry", "Gigli", d);
        addContact("virgie.werner@tawuctuj.cf", "Virgie", "Werner", d);
        addContact("gregory.cozzi@eh.ru", "Gregory", "Cozzi", d);
        addContact("lucinda.gil@fajjusuz.kr", "Lucinda", "Gil", d);
        addContact("gertrude.verbeek@pave.cc", "Gertrude", "Verbeek", d);
        addContact("mattie.graham@ispaviw.gt", "Mattie", "Graham", d);
        addContact("bryan.shaw@ha.ee", "Bryan", "Shaw", d);
        addContact("essie.adams@iliat.cw", "Essie", "Adams", d);
        addContact("gary.osborne@do.ga", "Gary", "Osborne", d);

        return d;
    }

    static Random r = new Random();
    private static void addContact(String mail, String first, String last, CrmData d) {
        Company company = d.getCompanies().get(r.nextInt(d.getCompanies().size()));
        var contact = new Contact(first, last, mail, company, d.getStatuses().get(r.nextInt(d.getStatuses().size())));
        company.getEmployees().add(contact);
        d.getContacts().add(contact);
    }

    public List<Contact> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return new ArrayList<>(crmData.getContacts());
        } else {
            var filter = stringFilter.toLowerCase();
            return crmData.getContacts().stream().filter(c ->
                    c.getFirstName().toLowerCase().contains(filter) ||
                            c.getLastName().toLowerCase().contains(filter)
            ).toList();
        }
    }

    public long countContacts() {
        return crmData.getContacts().size();
    }

    public void deleteContact(Contact contact) {
        crmData.getContacts().remove(contact);
        save();
    }

    private void save() {
        try {
            long start = System.currentTimeMillis();
            Files.write(file, serializer.serialize(crmData));
            System.out.println("Saved in " + (System.currentTimeMillis() - start) + "ms");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveContact(Contact contact) {
        if(!crmData.getContacts().contains(contact)) {
            crmData.getContacts().add(contact);
        }
        save();
    }

    public List<Company> findAllCompanies() {
        return new ArrayList<>(crmData.getCompanies());
    }

    public List<Status> findAllStatuses(){
        return new ArrayList<>(crmData.getStatuses());
    }
}