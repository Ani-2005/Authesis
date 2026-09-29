package devPilot.Service;

import java.util.UUID;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.transaction.annotation.Transactional;

import com.openai.models.beta.responses.BetaTool.Mcp.RequireApproval.McpToolApprovalFilter.Never;

import devPilot.Entity.User;
import devPilot.Repo.UserRepository;

public class Userservice {
    public final UserRepository userRepository = null;
    public final TextEncryptor textEncryptor = null;

    @Transactional(readOnly = true)
    public User requiredById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public  String decryptAccessToken(User user) {
        return textEncryptor.decrypt(user.getAccessToken());
    }

    private static Long toLong(Object value){
        if(value instanceof Number number){
            return number.longValue();
        }
        return Long.parseLong(String.valueOf(value));
    }
}
