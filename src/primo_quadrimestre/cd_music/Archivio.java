package primo_quadrimestre.cd_music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Archivio {
    private final List<Cd> cds;

    public Archivio() {
        this.cds = new ArrayList<>();
    }

    public List<Cd> getCds() {
        return cds.stream()
                .map(Cd::new)
                .collect(Collectors.toList());
    }

    public void add(Cd... cds) {
        this.cds.addAll(Arrays.asList(cds));
    }

    public List<Cd> getCdInVetrina() {
        return cds.stream()
                .filter(Cd::isInVetrina)
                .map(Cd::new)
                .collect(Collectors.toList());
    }

    public List<Cd> getCdNonInVetrina() {
        return cds.stream()
                .filter(cd -> !cd.isInVetrina())
                .map(Cd::new)
                .collect(Collectors.toList());
    }

    public Cd findByCode(String codice) {
        return cds.stream()
                .filter(cd -> cd.getCodice().equals(codice))
                .findFirst()
                .map(Cd::new)
                .orElse(null);
    }
}
