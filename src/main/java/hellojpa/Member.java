package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    @Embedded
//    private Period workPeriod;
//
//    @Embedded
//    private Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
