package org.elis.primo.mapper;

import org.elis.primo.dto.request.CreaAutomobileDTO;
import org.elis.primo.dto.response.AutomobileDTO;
import org.elis.primo.model.Automobile;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutomobileMapper {

    public Automobile toEntity(CreaAutomobileDTO dto) {
        Automobile automobile = new Automobile();
        automobile.setMarca(dto.getMarca());
        automobile.setModello(dto.getModello());
        automobile.setTarga(dto.getTarga());
        automobile.setDataImmatricolazione(dto.getDataImmatricolazione());
        automobile.setCilindrata(dto.getCilindrata());
        automobile.setColore(dto.getColore());
        automobile.setNIncidenti(dto.getNIncidenti());
        automobile.setKm(dto.getKm());
        automobile.setCambio(dto.getCambio());
        return automobile;
    }

    public AutomobileDTO toAutomobileDTO(Automobile auto) {
        String nomeProprietario =auto.getProprietario()==null?
                "":auto.getProprietario().getNome();
        String cognomeProprietario=auto.getProprietario()==null?
                "":auto.getProprietario().getCognome();
        return new AutomobileDTO(
                auto.getId(),
                auto.getMarca(),
                auto.getModello(),
                auto.getTarga(),
                auto.getDataImmatricolazione().format(DateTimeFormatter.ofPattern("MMMM yyyy")),
                auto.getCilindrata(),
                nomeProprietario,
                cognomeProprietario,
                auto.getColore(),
                auto.getNIncidenti(),
                auto.getKm(),
                auto.getCambio());
    }

    public List<AutomobileDTO> toAutomobileDTO(List<Automobile> auto) {
        return auto==null?new ArrayList<>():auto.stream()
                .map(this::toAutomobileDTO).toList();
    }
}
