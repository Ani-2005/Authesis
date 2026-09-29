package devPilot.Entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Table (name = "users")
@Builder                                     
public class User {

    @Id 
    @GeneratedValue (strategy=GenerationType.UUID)
    private UUID id;
     
    @Column (name="github_id", unique = true, nullable = false)
    private Long githubId;

    @Column (name="github_username", length = 100, nullable = false)
    private String githubusername;

    @Column (name="display_name", length = 100, nullable = false)
    private String displayName;

    @Column (name="avatar_url", length = 255, nullable = false)
    private String avatarUrl;

    @Column (name="access_token", columnDefinition = "TEXT", nullable = false)
    private String accessToken;

    @Column (name="token_scopes", length = 255)
    private String tokenScopes;

    @Column (name="created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        if(createdAt == null) {
            createdAt = Instant.now();
        }
    }
}
