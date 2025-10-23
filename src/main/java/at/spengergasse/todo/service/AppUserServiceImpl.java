package at.spengergasse.todo.service;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.repository.AppUserRepository;
import at.spengergasse.todo.viewmodel.AppUserJobTitleRequest;
import at.spengergasse.todo.viewmodel.AppUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<AppUser> listAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser save(AppUserRequest appUserRequest) {

        return appUserRepository.save(new AppUser(
                appUserRequest.firstName(), appUserRequest.lastName(), appUserRequest.jobTitle()));
    }

    @Override
    public Optional<AppUser> getById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public Optional<AppUser> updateJobTitle(AppUserJobTitleRequest request) {
        var optionalAppUser = getById(request.id());

        if(optionalAppUser.isPresent())
        {
            var appUser = optionalAppUser.get();

            appUser.setJobTitle(request.jobTitle());

            return Optional.of(save(appUser));
        }

        return Optional.empty();
    }
}
