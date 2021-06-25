package io.dsub.discogs.common.master.entity;

import io.dsub.discogs.common.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "master_video",
        uniqueConstraints =
        @UniqueConstraint(
                name = "uq_master_video_master_id_url",
                columnNames = {"master_id", "url"}))
public class MasterVideo extends BaseTimeEntity {

    private static final Long SerialVersionUID = 1L;

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", length = 2000)
    private String title;

    @Column(name = "description", length = 40000)
    private String description;

    @Column(name = "url", length = 5000)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "master_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_master_video_master_id_master"))
    private Master master;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MasterVideo that = (MasterVideo) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1261579609;
    }
}
