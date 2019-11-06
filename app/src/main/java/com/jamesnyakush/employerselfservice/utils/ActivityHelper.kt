@file:JvmName("ActivityHelper")
package com.jamesnyakush.employerselfservice.utils

import android.content.Intent

/**
 * Helpers to start activities in a modularized world.
 */

private const val PACKAGE_NAME = "com.jamesnyakush.employerselfservice"


fun intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className
    )
}

interface AddressableActivity {
    val className: String
}

object Activities {
    object LeaveModule {

        object leave : AddressableActivity {
            override val className = "com.jamesnyakush.leave.views.ui.activities.LeaveActivity"
        }

    }
    object ClaimModule {

        object claim : AddressableActivity {
            override val className = "com.jamesnyakush.claims.views.ui.activities.ClaimActivity"
        }

    }
    object LabourModule {

        object labour : AddressableActivity {
            override val className = "com.jamesnyakush.labour.views.ui.activities.LabourActivity"
        }

    }

    object RecruitmentModule {

        object recruitment : AddressableActivity {
            override val className = "package com.jamesnyakush.recruitment.views.ui.activities.RecruitmentActivity"
        }

    }

    object ManagerModule {

        object manager : AddressableActivity {
            override val className = "com.jamesnyakush.manager.views.ui.activities.ManagerActivity"
        }

    }

    object ProfilesModule {

        object profiles : AddressableActivity {
            override val className = "com.jamesnyakush.profile.views.ui.activities.Profile"
        }

    }
}