package pl.greenwind.reallifequestlog.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import javax.persistence.*;
import javax.swing.tree.DefaultMutableTreeNode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author piotr.janik
 */
@Entity
@Table(name = "quest")
public class Quest extends DefaultMutableTreeNode implements Serializable {

    private Long id;
    private String name;
    private Date dateStart;
    private Date dateStop;
    private String description;
    private int xp;
    private int typeId;

    public Quest() {
    }

    public Quest(Quest parent) {
        super(parent);
    }

    @Column(name = "date_start", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Column(name = "date_stop")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quest_SEQ")
    @SequenceGenerator(name = "quest_SEQ", sequenceName = "quest_id_seq", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_quest_id")
    @Override
    public Quest getParent() {
        return (Quest) parent;
    }

    public void setParent(Quest parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Quest> getChildren() {
        return children;
    }

    public void setChildren(Collection<Quest> children) {
        this.children = new Vector(children);
    }

    @Column(name = "type_id", nullable = false)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Column(nullable = false)
    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return name;
    }
}
