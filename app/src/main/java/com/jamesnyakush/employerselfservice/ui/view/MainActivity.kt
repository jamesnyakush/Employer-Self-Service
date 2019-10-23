package com.jamesnyakush.employerselfservice.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidstudy.devfest19.utils.CustomGridLayoutManager
import com.androidstudy.devfest19.utils.toast
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.jamesnyakush.employerselfservice.R
import com.jamesnyakush.employerselfservice.ui.adapter.DynamicModuleRecyclerViewAdapter
import com.jamesnyakush.employerselfservice.ui.model.DynamicModule
import com.jamesnyakush.employerselfservice.utils.Activities
import com.jamesnyakush.employerselfservice.utils.Constants
import com.jamesnyakush.employerselfservice.utils.intentTo
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var splitInstallManager: SplitInstallManager

    private val LeaveModule by lazy { getString(R.string.title_leave) }
    private val ClaimModule by lazy { getString(R.string.title_claims) }
    private val LabourModule by lazy { getString(R.string.title_labour) }
    private val RecruitmentModule by lazy { getString(R.string.title_recruitment) }
    private val ManagerModule by lazy { getString(R.string.title_manager) }
    private val ProfileModule by lazy { getString(R.string.title_profile) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splitInstallManager = SplitInstallManagerFactory.create(this)

        setup()
    }

    private fun setup() {
        val layoutManager = CustomGridLayoutManager(this, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewModules.layoutManager = layoutManager

        val adapter =
            DynamicModuleRecyclerViewAdapter(
                prepareDynamicModules(),
                this
            ) { position ->
                val modules = prepareDynamicModules()[position]
                when (modules.dynamicModuleTitle) {
                    //
                    Constants.MAIN_DASHBOARD_CARD_LEAVE -> {
                        if (splitInstallManager.installedModules.contains(LeaveModule)) {
                            startActivity(intentTo(Activities.LeaveModule.leave))
                        } else {
                            toast("Music Module is not installed")
                        }
                    }
                    //
                    Constants.MAIN_DASHBOARD_CARD_CLAIM -> {
                        if (splitInstallManager.installedModules.contains(ClaimModule)) {
                            startActivity(intentTo(Activities.ClaimModule.claim))
                        } else {
                            toast("News Module is not installed")
                        }
                    }
                    //
                    Constants.MAIN_DASHBOARD_CARD_LABOUR -> {
                        if (splitInstallManager.installedModules.contains(LabourModule)) {
                            startActivity(intentTo(Activities.LabourModule.labour))
                        } else {
                            toast("Movie Module is not installed")
                        }
                    }


                    Constants.MAIN_DASHBOARD_CARD_RECRUITMENT -> {
                        if (splitInstallManager.installedModules.contains(RecruitmentModule)) {
                            startActivity(intentTo(Activities.RecruitmentModule.recruitment))
                        } else {
                            toast("Weather Module is not installed")
                        }
                    }

                    Constants.MAIN_DASHBOARD_CARD_MANAGER -> {
                        if (splitInstallManager.installedModules.contains(ManagerModule)) {
                            startActivity(intentTo(Activities.ManagerModule.manager))
                        } else {
                            toast("Weather Module is not installed")
                        }
                    }

                    Constants.MAIN_DASHBOARD_CARD_PROFILE -> {
                        if (splitInstallManager.installedModules.contains(ProfileModule)) {
                            startActivity(intentTo(Activities.ProfilesModule.profiles))
                        } else {
                            toast("Weather Module is not installed")
                        }
                    }


                }
            }
        recyclerViewModules.adapter = adapter

    }

    private fun prepareDynamicModules(): List<DynamicModule> {
        val models = ArrayList<DynamicModule>()
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_LEAVE,
                R.drawable.ic_wristwatch
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_CLAIM,
                R.drawable.ic_answer
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_LABOUR,
                R.drawable.ic_labor_woman
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_RECRUITMENT,
                R.drawable.ic_job_seeker
            )
        )

        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_MANAGER,
                R.drawable.ic_boss
            )
        )

        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_PROFILE,
                R.drawable.ic_team
            )
        )
        return models
    }
}
