let $usernameFld;
let $passwordFld;
let $firstNameFld;
let $lastNameFld;
let $roleFLd;
let $tBody;

let $searchBtn;
let $createBtn;
let $editBtn;
let $userRowTemplate;
let userAdminService;

let selectedUser;
let users;
let userById;

const createUser = (user) => {
    userAdminService.createUser(user)
        .then((data) => {
            users.push(data);
            renderUser(users);
        });
}

const findAllUsers = () => {
    userAdminService.findAllUsers()
        .then((data) => {
            users = data;
            renderUser(users);
        });
}

const findUserById = (userId) => {
    userAdminService.findUserById(userId)
        .then((data) => {
            userById = data;
        });
}

const getSelectedUser = (event) => {
    let selectedButton = $(event.target);
    selectedUser = users.find(user => user.id === selectedButton.attr("id"))

    // update table header
    $usernameFld.val(selectedUser.username);
    $roleFLd.val(selectedUser.role);
    $passwordFld.val(selectedUser.password);
    $lastNameFld.val(selectedUser.lastName);
    $firstNameFld.val(selectedUser.firstName);
}

const updateUser = (event) => {
    if (selectedUser !== null && selectedUser !== undefined) {
        // update selectedUser value
        selectedUser.username = $usernameFld.val();
        selectedUser.password =  $passwordFld.val();
        selectedUser.lastName = $lastNameFld.val();
        selectedUser.firstName = $firstNameFld.val();
        selectedUser.role = $roleFLd.val();

        // called updateUser function
        userAdminService.updateUser(selectedUser.id, selectedUser)
            .then((status) => {
                console.log(status);
                userAdminService.findAllUsers()
                    .then((data) => {
                        users = data;
                        renderUser(users);
                    });
            });
        resetInputs();
    } else
        console.log("No user selected for update");
}

const deleteUser = (event) => {
    const selectedButton = $(event.target);
    const idx = selectedButton.attr("id");
    const userId = users[idx].id;

    userAdminService.deleteUser(userId)
        .then(() => {
            users.splice(idx, 1);
            renderUser(users);
        })
}

const renderUser = (users) => {
    $tBody.empty();
    console.log(`number of users are ${users.length}`);
    for (var i = 0; i < users.length; i++) {
        const user = users[i];
        $tBody.prepend(`
            <tr class="wbdv-template wbdv-user wbdv-hidden">
                <td class="wbdv-username">${user.username}</td>
                <td>&nbsp;</td>
                <td class="wbdv-first-name">${user.firstName}</td>
                <td class="wbdv-last-name">${user.lastName}</td>
                <td class="wbdv-role">${user.role}</td>
                <td class="wbdv-actions">
                    <span class="float-right">
                        <button type="button" class="btn" >
                            <i class="fa-2x fa fa-times wbdv-remove-btn" id="${i}"></i>
                        </button>
                        <button type="button" class="btn">
                            <i class="fa-2x fa fa-pencil wbdv-modify-btn" id="${user.id}"></i>
                        </button>
                    </span>
                </td>
            </tr>
        `);
    }
    $(".wbdv-remove-btn").click(deleteUser);
    $(".wbdv-modify-btn").click(getSelectedUser)
}

const resetInputs = () => {
    $usernameFld.val("");
    $passwordFld.val("");
    $lastNameFld.val("");
    $firstNameFld.val("");
    $roleFLd.val("Faculty"); // set back to default value
    selectedUser = null; // reset selected user
}

const main = () => {
    $usernameFld = $("#username");
    $passwordFld = $("#password");
    $firstNameFld = $("#first-name");
    $lastNameFld = $("#last-name");
    $roleFLd = $("#role");
    $tBody = $(".wbdv-tbody");
    $searchBtn = $(".wbdv-search-btn");
    $editBtn = $(".wbdv-edit-btn");
    $createBtn = $(".wbdv-create-btn");
    $userRowTemplate = $(".wbdv-template");
    userAdminService = new UserAdminServiceClient();

    users = [];
    selectedUser = null;
    userById = null;

    $createBtn.click(() => {
        console.log("at main createBtn")
        createUser({
            "username" : $usernameFld.val(),
            "password" : $passwordFld.val(),
            "lastName" : $lastNameFld.val(),
            "firstName" : $firstNameFld.val(),
            "role" : $roleFLd.val()
        });
        resetInputs();
    });

    $editBtn.click(updateUser);
    findAllUsers();
}

$(main);