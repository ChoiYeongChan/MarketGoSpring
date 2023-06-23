package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "market_index")
public class MarketIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer indexId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member memberId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id1")
    private Store storeId1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id2")
    private Store storeId2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id3")
    private Store storeId3;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id4")
    private Store storeId4;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id5")
    private Store storeId5;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id6")
    private Store storeId6;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id7")
    private Store storeId7;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id8")
    private Store storeId8;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id9")
    private Store storeId9;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id10")
    private Store storeId10;
}
