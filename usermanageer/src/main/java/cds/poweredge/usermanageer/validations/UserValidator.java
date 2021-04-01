package cds.poweredge.usermanageer.validations;

import cds.poweredge.usermanageer.exceptions.ApiRequestException;
import cds.poweredge.usermanageer.exceptions.NotFoundException;
import cds.poweredge.usermanageer.models.User;
import cds.poweredge.usermanageer.services.UserService;

public class UserValidator {

    public Boolean isValid(User user, UserService userService){
        if(user.getRolId() != null &&  user.getRolId().intValue() == user.getRolId() && user.getName() != null && user.getActive() != null){
            if (userService.existsByName(user)) {
                throw new ApiRequestException(
                    "Name " + user.getName() + " taken");
            }
        }else{
            throw new ApiRequestException("Fields rolId, name, active are required") ;
        }
        return true;
    }

    public Boolean isValidId(Long userId, UserService userService){
        if(userId != null && userId.intValue() == userId){
            if(!userService.existsById(userId)) {
                throw new NotFoundException(
                        "User with id " + userId + " does not exists");
            }
        }else{
            throw new ApiRequestException("Field id is required") ;
        }
        return true;
    }
}
